package api;

import model.ArticleModel;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.List;

/**
 * Created by wulei on 1/9/17.
 */
@Path("/article")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public interface OrderResource {

    @GET
    @Path("/allarticles")
    List<ArticleModel> getArticles();

    @GET
    @Path("/detail/{articleId}")
    ArticleModel getdetail(@PathParam("articleId") String articleId);

    @POST
    @Path("/modify")
    String modifyArticle(ArticleModel articleModel);




}
