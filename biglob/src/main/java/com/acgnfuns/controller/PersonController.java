package com.acgnfuns.controller;

import com.acgnfuns.controller.base.AbstractRestHandler;
import com.acgnfuns.domain.DocumentBinary;
import com.acgnfuns.domain.DocumentText;
import com.acgnfuns.domain.Person;
import com.acgnfuns.service.PersonService;
import com.mongodb.client.gridfs.model.GridFSFile;
import io.micrometer.core.instrument.util.IOUtils;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.bson.Document;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.gridfs.GridFsOperations;
import org.springframework.data.mongodb.gridfs.GridFsResource;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;

@RestController
@RequestMapping(value = "/v1/person")
@Api(tags = {"person"})
public class PersonController extends AbstractRestHandler {

    @Autowired
    private PersonService personService;

    @Autowired
    private GridFsOperations gridFsOperations;

    @RequestMapping(value = "/savePerson",
            method = RequestMethod.POST,
            produces = {"application/json"})
    @ResponseStatus(HttpStatus.OK)
    @ApiOperation(value = "Save a Person object.", notes = "You have to provide a person object.")
    public
    @ResponseBody
    Person savePerson(@ApiParam(value = "The person object.", required = true) @RequestBody Person person,
                      HttpServletRequest request, HttpServletResponse response) throws Exception {
        DocumentText descText = person.getDesc();
        InputStream descIs = new ByteArrayInputStream(descText.getDocText().getBytes(Charset.forName( "UTF-8" )));
        ObjectId descRefId = gridFsOperations.store(descIs, descText.getDocName());
        descText.setDocId(descRefId.toString());
        descText.setDocText(null);
//        person.setDescRefId(descRefId.toString());

        DocumentBinary avaBinary = person.getAva();
        InputStream avatarIs = new ByteArrayInputStream(avaBinary.getDocBinary());
        ObjectId avatarRefId = gridFsOperations.store(avatarIs, avaBinary.getDocName());
        avaBinary.setDocId(avatarRefId.toString());
        avaBinary.setDocBinary(null);
//        person.setAvatarRefId(avatarRefId.toString());
        return personService.savePerson(person);
    }

    @RequestMapping(value = "/getPersonById",
            method = RequestMethod.GET,
            produces = {"application/json"})
    @ResponseStatus(HttpStatus.OK)
    @ApiOperation(value = "Get a Person by id.", notes = "You have to provide a person id.")
    public
    @ResponseBody
    Person getPersonById(@ApiParam(value = "The person object.", required = true) @RequestParam Integer id,
                      HttpServletRequest request, HttpServletResponse response) throws Exception {
        Person person = personService.getPersonById(id);
        if(null != person)
        {
            Query descQuery = new Query();
            descQuery.addCriteria(Criteria.where("_id").is(new ObjectId(person.getDescRefId())));
            GridFSFile descFile = gridFsOperations.findOne(descQuery);
            Document descDocument = descFile.getMetadata();
            GridFsResource descResource = gridFsOperations.getResource(descFile);
            person.getDesc().setDocText(IOUtils.toString(descResource.getInputStream(), StandardCharsets.UTF_8));

            Query avatarQuery = new Query();
            avatarQuery.addCriteria(Criteria.where("_id").is(new ObjectId(person.getAvatarRefId())));
            GridFSFile avatarFile = gridFsOperations.findOne(avatarQuery);
            Document avatarDocument = avatarFile.getMetadata();
            GridFsResource avatarResource = gridFsOperations.getResource(avatarFile);
            person.getAva().setDocBinary(avatarResource.getInputStream().readAllBytes());
        }
        return person;
    }
}
