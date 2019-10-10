package com.revature.rest;

import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Response;

import com.revature.dao.ZipCodeDaoImpl;
import com.revature.model.ZipCodes;

@Path(value = "zipcodes")
public class ZipCodeService {
	@GET
	@Path("/{zipCode}")
	@Produces(value = { "application/json", "application/xml" })
	public Response getZipCode(@PathParam("zipCode") int zipCode) {
		ZipCodes z = ZipCodeDaoImpl.getInfoByZip(zipCode);
		return Response.status(Response.Status.OK).entity(z).build();
	}

	@POST
	@Path("/")
	@Produces(value = { "application/json", "application/xml" })
	public Response createZipCode(ZipCodes z) {
		ZipCodeDaoImpl.addZipCode(z);
		System.out.println(z);
		return Response.status(Response.Status.OK).entity("ZipCode " + z.getZipCode() + " was added sucessfully!")
				.build();
	}
}