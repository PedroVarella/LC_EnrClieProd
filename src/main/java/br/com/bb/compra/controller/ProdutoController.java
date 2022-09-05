package br.com.bb.compra.controller;

import br.com.bb.compra.model.Produto;
import br.com.bb.compra.service.ProdutoService;
import lombok.RequiredArgsConstructor;

import javax.validation.Valid;
import javax.ws.rs.*;
import javax.ws.rs.core.Response;

@Path("/produtos")
@RequiredArgsConstructor
public class ProdutoController {

    private final ProdutoService produtoService;

    @GET
    @Path("/{id}")
    public Response getId(@PathParam("id") Long id) {
        return Response.ok(produtoService.buscaPorId(id)).build();
    }

    @POST
    public Response salvar(@Valid Produto produto) {
        return Response.ok(produtoService.salvar(produto)).build();
    }

    @GET
    public Response listar(@QueryParam("filtro") @DefaultValue("") String filtro,
                           @QueryParam("page") @DefaultValue("0") Integer page,
                           @QueryParam("size") @DefaultValue("20") Integer size) {
        return Response.ok(produtoService.listar(filtro, page, size)).build();
    }

    @DELETE
    @Path("/{id}")
    public Response deletarProdutoPorId(@PathParam("id") Long id) {
        return Response.ok(produtoService.deletar(id)).build();
    }

}
