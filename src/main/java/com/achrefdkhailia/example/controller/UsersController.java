package com.achrefdkhailia.example.controller;

import com.achrefdkhailia.example.domain.User;
import com.achrefdkhailia.example.service.UserService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.List;

@Component
@Path("/users")
@Api(value = "/users") // Enables Swagger Documentation
@Produces(MediaType.APPLICATION_JSON)
public class UsersController {

    @Autowired
    private UserService userService;

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @ApiOperation(value = "add new user with passed user fields")
    public User save(final User user) {
        return userService.save(user).get();
    }

    @GET
    @Path("/{id}")
    @ApiOperation(value = "Finds an exist user with passed ID")
    public User findById(@PathParam("id") final long userId) {
        return userService.findById(userId).get();
    }

    @GET
    @ApiOperation(value = "Find all users", response = User.class)
    public List<User> findAll() {
        return userService.findAll().get();
    }

    @PUT
    @Path("/{id}")
    @ApiOperation(value = "Updates an exist user with passed user fields")
    public User update(@PathParam("id") final long id,
                       final User user) {
        return userService.update(id, user).get();
    }

    @DELETE
    @Path("/{id}")
    @ApiOperation(value = "Deletes an exist user with ID")
    public boolean deleteById(@PathParam("id") final long userId) {

        try {
            userService.deleteById(userId);
        } catch (java.lang.Exception e) {
            e.printStackTrace();
            return false;
        }
        return true;
    }
}

