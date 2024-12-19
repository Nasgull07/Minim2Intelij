package edu.upc.dsa.services;
import edu.upc.dsa.*;
import edu.upc.dsa.models.*;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.apache.log4j.Logger;
import javax.ws.rs.*;
import javax.ws.rs.core.*;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import edu.upc.dsa.models.Denuncia;

@Api(value = "/denuncias", description = "Endpoint to denuncias")
@Path("/denuncias")
@Produces(MediaType.APPLICATION_JSON)
public class DenunciaService extends Application{
    Denuncia denuncias;
    private static final Logger logger = Logger.getLogger(DenunciaService.class);


    @POST
    @Path("/")
    @Consumes(MediaType.APPLICATION_JSON)
    @ApiOperation(value = "create a new Denuncia", notes = "Creates a new denuncia")
    @ApiResponses(value = {
            @ApiResponse(code = 201, message = "Successful"),
            @ApiResponse(code = 400, message = "Invalid input")
    })
    public Response createDenuncia(Denuncia denuncia) {
        if (denuncia == null || denuncia.getTitle() == null || denuncia.getMessage() == null || denuncia.getSender() == null) {
            return Response.status(400).entity("Invalid input").build();
        }
        // Logic to save the denuncia
        logger.info("Denuncia created: " + denuncia.getTitle());
        return Response.status(201).entity("Denuncia created successfully").build();
    }

}
