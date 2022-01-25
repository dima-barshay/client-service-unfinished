package app.controller;

import app.dao.impl.ClientDaoImpl;
import app.dao.impl.PersonalInfoDaoImpl;
import app.dao.impl.PhoneNumberDaoImpl;
import app.service.ClientService;
import app.service.impl.ClientServiceImpl;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Path("clients")
public class ClientController {
    private final ClientService clientService = new ClientServiceImpl(new ClientDaoImpl(),
            new PersonalInfoDaoImpl(), new PhoneNumberDaoImpl());

    @GET
    @Path("register")
    @Produces(MediaType.APPLICATION_JSON)
    public Response add(@QueryParam("fullName") String fullName,
                        @QueryParam("mainPhoneNumber") String mainPhoneNumber) {
        if (!validator.isValid(fullName, mainPhoneNumber)) {
            return Response.status(Response.Status.BAD_REQUEST).build();
        }
        Long id = clientService.add(fullName, mainPhoneNumber);
        String message = "{\"Client ID\": \"" + id + "\"}";
        return Response.status(Response.Status.OK).entity(message).build();

    }
}
