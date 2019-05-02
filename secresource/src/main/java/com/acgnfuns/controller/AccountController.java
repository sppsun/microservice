package com.acgnfuns.controller;

import com.acgnfuns.controller.base.AbstractRestHandler;
import com.acgnfuns.exception.RestErrorInfo;
import com.acgnfuns.domain.Account;
import com.acgnfuns.domain.RestResponse;
import com.acgnfuns.service.AccountService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.Authorization;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.web.bind.annotation.*;

import javax.security.auth.login.AccountException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/*
 * Demonstrates how to set up RESTful API endpoints using Spring MVC
 */

@RestController
@RequestMapping(value = "/v1/account")
@Api(tags = {"account"})
public class AccountController extends AbstractRestHandler {

    @Autowired
    private AccountService accountService;

    @RequestMapping(value = "/getAccount", method = RequestMethod.GET, produces = {"application/json"})
    @ResponseStatus(HttpStatus.OK)
    @ApiOperation(value = "getAccount.", notes = "You can getAccount.")
    public
    @ResponseBody
    Account getAccount(HttpServletRequest request, HttpServletResponse response) throws Exception {
        String username = SecurityContextHolder.getContext().getAuthentication().getName();
        return accountService.findAccountByUsername(username);
    }

    @RequestMapping(value = "/registerAccount", method = RequestMethod.POST, produces = {"application/json"})
    @ResponseStatus(HttpStatus.OK)
    @ApiOperation(value = "registerAccount.", notes = "You can registerAccount.")
    public
    @ResponseBody
    ResponseEntity<?> registerAccount(HttpServletRequest request, HttpServletResponse response, @RequestBody Account account) throws Exception {
        try {
            account.grantAuthority("ROLE_USER");
            return new ResponseEntity<Object>(
                    accountService.register( account ), HttpStatus.OK);
        } catch (AccountException e) {
            e.printStackTrace();
            return new ResponseEntity<RestErrorInfo>(new RestErrorInfo(e, "Register failed."),HttpStatus.BAD_REQUEST );
        }
    }

    @RequestMapping(value = "/removeAccount", method = RequestMethod.DELETE, produces = {"application/json"})
    @ResponseStatus(HttpStatus.OK)
    @ApiOperation(value = "removeAccount.", authorizations={
            @Authorization(value = "Bearer")
    }, notes = "You can removeAccount.")
    public
    @ResponseBody
    ResponseEntity<?> removeAccount(HttpServletRequest request, HttpServletResponse response) throws Exception {
        try {
            accountService.removeAuthenticatedAccount();
            return new ResponseEntity<Object>(new RestResponse("User removed."), HttpStatus.OK);
        } catch (UsernameNotFoundException e) {
            e.printStackTrace();
            return new ResponseEntity<Object>(new RestErrorInfo(e, "Remove user failed."), HttpStatus.OK);
        }
    }

}
