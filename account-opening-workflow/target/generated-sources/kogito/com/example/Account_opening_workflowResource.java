/*
 * Copyright 2021 Red Hat, Inc. and/or its affiliates.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *       http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.example;

import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;
import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.NotFoundException;
import javax.ws.rs.PATCH;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.DefaultValue;
import javax.ws.rs.PathParam;
import javax.ws.rs.QueryParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.HttpHeaders;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriBuilder;
import javax.ws.rs.core.UriInfo;
import javax.ws.rs.core.Response.Status;
import org.eclipse.microprofile.openapi.annotations.Operation;
import org.eclipse.microprofile.openapi.annotations.tags.Tag;
import org.jbpm.util.JsonSchemaUtil;
import org.kie.kogito.process.Process;
import org.kie.kogito.process.ProcessInstance;
import org.kie.kogito.process.WorkItem;
import org.kie.kogito.process.ProcessService;
import org.kie.kogito.process.workitem.Attachment;
import org.kie.kogito.process.workitem.AttachmentInfo;
import org.kie.kogito.process.workitem.Comment;
import org.kie.kogito.process.workitem.Policies;
import org.kie.kogito.process.workitem.TaskModel;
import org.kie.kogito.auth.IdentityProvider;
import org.kie.kogito.auth.IdentityProviders;
import org.kie.kogito.auth.SecurityPolicy;

@Path("/account_opening_workflow")
@javax.enterprise.context.ApplicationScoped()
public class Account_opening_workflowResource {

    @javax.inject.Inject()
    @javax.inject.Named("account_opening_workflow")
    Process<Account_opening_workflowModel> process;

    @Inject
    ProcessService processService;

    @POST
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    @Operation(summary = "account_opening_workflow", description = "")
    public Response createResource_account_opening_workflow(@Context HttpHeaders httpHeaders, @Context UriInfo uriInfo, @QueryParam("businessKey") @DefaultValue("") String businessKey, @javax.validation.Valid() @javax.validation.constraints.NotNull() Account_opening_workflowModelInput resource) {
        ProcessInstance<Account_opening_workflowModel> pi = processService.createProcessInstance(process, businessKey, Optional.ofNullable(resource).orElse(new Account_opening_workflowModelInput()).toModel(), httpHeaders.getRequestHeaders(), httpHeaders.getHeaderString("X-KOGITO-StartFromNode"));
        return Response.created(uriInfo.getAbsolutePathBuilder().path(pi.id()).build()).entity(pi.checkError().variables().toModel()).build();
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Operation(summary = "account_opening_workflow", description = "")
    public List<Account_opening_workflowModelOutput> getResources_account_opening_workflow() {
        return processService.getProcessInstanceOutput(process);
    }

    @GET
    @Path("schema")
    @Produces(MediaType.APPLICATION_JSON)
    @Operation(summary = "account_opening_workflow", description = "")
    public Map<String, Object> getResourceSchema_account_opening_workflow() {
        return JsonSchemaUtil.load(this.getClass().getClassLoader(), process.id());
    }

    @GET
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    @Operation(summary = "account_opening_workflow", description = "")
    public Account_opening_workflowModelOutput getResource_account_opening_workflow(@PathParam("id") String id) {
        return processService.findById(process, id).orElseThrow(NotFoundException::new);
    }

    @DELETE
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    @Operation(summary = "account_opening_workflow", description = "")
    public Account_opening_workflowModelOutput deleteResource_account_opening_workflow(@PathParam("id") final String id) {
        return processService.delete(process, id).orElseThrow(NotFoundException::new);
    }

    @PUT
    @Path("/{id}")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    @Operation(summary = "account_opening_workflow", description = "")
    public Account_opening_workflowModelOutput updateModel_account_opening_workflow(@PathParam("id") String id, Account_opening_workflowModel resource) {
        return processService.update(process, id, resource).orElseThrow(NotFoundException::new);
    }

    @PATCH
    @Path("/{id}")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    @Operation(summary = "account_opening_workflow", description = "")
    public Account_opening_workflowModelOutput updateModelPartial_account_opening_workflow(@PathParam("id") String id, Account_opening_workflowModel resource) {
        return processService.updatePartial(process, id, resource).orElseThrow(NotFoundException::new);
    }

    @GET
    @Path("/{id}/tasks")
    @Produces(MediaType.APPLICATION_JSON)
    @Operation(summary = "account_opening_workflow", description = "")
    public List<TaskModel> getTasks_account_opening_workflow(@PathParam("id") String id, @QueryParam("user") final String user, @QueryParam("group") final List<String> groups) {
        return processService.getTasks(process, id, SecurityPolicy.of(IdentityProviders.of(user, groups))).orElseThrow(NotFoundException::new).stream().map(com.example.Account_opening_workflow_TaskModelFactory::from).collect(Collectors.toList());
    }

    @POST
    @Path("/{id}/CPUAuthorize/{taskId}")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Account_opening_workflowModelOutput completeTask_CPUAuthorize_0(@PathParam("id") final String id, @PathParam("taskId") final String taskId, @QueryParam("phase") @DefaultValue("complete") final String phase, @QueryParam("user") final String user, @QueryParam("group") final List<String> groups, final com.example.Account_opening_workflow_1_TaskOutput model) {
        return processService.taskTransition(process, id, taskId, phase, SecurityPolicy.of(user, groups), model).orElseThrow(NotFoundException::new);
    }

    @PUT
    @Path("/{id}/CPUAuthorize/{taskId}")
    @Consumes(MediaType.APPLICATION_JSON)
    public com.example.Account_opening_workflow_1_TaskOutput saveTask_CPUAuthorize_0(@PathParam("id") final String id, @PathParam("taskId") final String taskId, @QueryParam("user") final String user, @QueryParam("group") final List<String> groups, final com.example.Account_opening_workflow_1_TaskOutput model) {
        return processService.saveTask(process, id, taskId, SecurityPolicy.of(user, groups), model, com.example.Account_opening_workflow_1_TaskOutput::fromMap).orElseThrow(NotFoundException::new);
    }

    @POST
    @Path("/{id}/CPUAuthorize/{taskId}/phases/{phase}")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Account_opening_workflowModelOutput taskTransition_CPUAuthorize_0(@PathParam("id") final String id, @PathParam("taskId") final String taskId, @PathParam("phase") final String phase, @QueryParam("user") final String user, @QueryParam("group") final List<String> groups, final com.example.Account_opening_workflow_1_TaskOutput model) {
        return processService.taskTransition(process, id, taskId, phase, SecurityPolicy.of(user, groups), model).orElseThrow(NotFoundException::new);
    }

    @GET
    @Path("/{id}/CPUAuthorize/{taskId}")
    @Produces(MediaType.APPLICATION_JSON)
    public com.example.Account_opening_workflow_1_TaskModel getTask_CPUAuthorize_0(@PathParam("id") String id, @PathParam("taskId") String taskId, @QueryParam("user") final String user, @QueryParam("group") final List<String> groups) {
        return processService.getTask(process, id, taskId, SecurityPolicy.of(user, groups), com.example.Account_opening_workflow_1_TaskModel::from).orElseThrow(NotFoundException::new);
    }

    @DELETE
    @Path("/{id}/CPUAuthorize/{taskId}")
    @Produces(MediaType.APPLICATION_JSON)
    public Account_opening_workflowModelOutput abortTask_CPUAuthorize_0(@PathParam("id") final String id, @PathParam("taskId") final String taskId, @QueryParam("phase") @DefaultValue("abort") final String phase, @QueryParam("user") final String user, @QueryParam("group") final List<String> groups) {
        return processService.taskTransition(process, id, taskId, phase, SecurityPolicy.of(user, groups), null).orElseThrow(NotFoundException::new);
    }

    @GET
    @Path("CPUAuthorize/schema")
    @Produces(MediaType.APPLICATION_JSON)
    public Map<String, Object> getSchema_CPUAuthorize_0() {
        return JsonSchemaUtil.load(this.getClass().getClassLoader(), process.id(), "CPUAuthorize");
    }

    @GET
    @Path("/{id}/CPUAuthorize/{taskId}/schema")
    @Produces(MediaType.APPLICATION_JSON)
    public Map<String, Object> getSchemaAndPhases_CPUAuthorize_0(@PathParam("id") final String id, @PathParam("taskId") final String taskId, @QueryParam("user") final String user, @QueryParam("group") final List<String> groups) {
        return processService.getSchemaAndPhases(process, id, taskId, "CPUAuthorize", SecurityPolicy.of(user, groups));
    }

    @POST
    @Path("/{id}/CPUAuthorize/{taskId}/comments")
    @Consumes(MediaType.TEXT_PLAIN)
    @Produces(MediaType.APPLICATION_JSON)
    public Response addComment_CPUAuthorize_0(@PathParam("id") final String id, @PathParam("taskId") final String taskId, @QueryParam("user") final String user, @QueryParam("group") final List<String> groups, String commentInfo, @Context UriInfo uriInfo) {
        return processService.addComment(process, id, taskId, SecurityPolicy.of(user, groups), commentInfo).map(comment -> Response.created(uriInfo.getAbsolutePathBuilder().path(comment.getId().toString()).build()).entity(comment).build()).orElseThrow(NotFoundException::new);
    }

    @PUT
    @Path("/{id}/CPUAuthorize/{taskId}/comments/{commentId}")
    @Consumes(MediaType.TEXT_PLAIN)
    @Produces(MediaType.APPLICATION_JSON)
    public Comment updateComment_CPUAuthorize_0(@PathParam("id") final String id, @PathParam("taskId") final String taskId, @PathParam("commentId") final String commentId, @QueryParam("user") final String user, @QueryParam("group") final List<String> groups, String comment) {
        return processService.updateComment(process, id, taskId, commentId, SecurityPolicy.of(user, groups), comment).orElseThrow(NotFoundException::new);
    }

    @DELETE
    @Path("/{id}/CPUAuthorize/{taskId}/comments/{commentId}")
    public Response deleteComment_CPUAuthorize_0(@PathParam("id") final String id, @PathParam("taskId") final String taskId, @PathParam("commentId") final String commentId, @QueryParam("user") final String user, @QueryParam("group") final List<String> groups) {
        return processService.deleteComment(process, id, taskId, commentId, SecurityPolicy.of(user, groups)).map(removed -> (removed ? Response.ok() : Response.status(Status.NOT_FOUND)).build()).orElseThrow(NotFoundException::new);
    }

    @POST
    @Path("/{id}/CPUAuthorize/{taskId}/attachments")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response addAttachment_CPUAuthorize_0(@PathParam("id") final String id, @PathParam("taskId") final String taskId, @QueryParam("user") final String user, @QueryParam("group") final List<String> groups, AttachmentInfo attachmentInfo, @Context UriInfo uriInfo) {
        return processService.addAttachment(process, id, taskId, SecurityPolicy.of(user, groups), attachmentInfo).map(attachment -> Response.created(uriInfo.getAbsolutePathBuilder().path(attachment.getId().toString()).build()).entity(attachment).build()).orElseThrow(NotFoundException::new);
    }

    @PUT
    @Path("/{id}/CPUAuthorize/{taskId}/attachments/{attachmentId}")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Attachment updateAttachment_CPUAuthorize_0(@PathParam("id") final String id, @PathParam("taskId") final String taskId, @PathParam("attachmentId") final String attachmentId, @QueryParam("user") final String user, @QueryParam("group") final List<String> groups, AttachmentInfo attachment) {
        return processService.updateAttachment(process, id, taskId, attachmentId, SecurityPolicy.of(user, groups), attachment).orElseThrow(NotFoundException::new);
    }

    @DELETE
    @Path("/{id}/CPUAuthorize/{taskId}/attachments/{attachmentId}")
    public Response deleteAttachment_CPUAuthorize_0(@PathParam("id") final String id, @PathParam("taskId") final String taskId, @PathParam("attachmentId") final String attachmentId, @QueryParam("user") final String user, @QueryParam("group") final List<String> groups) {
        return processService.deleteAttachment(process, id, taskId, attachmentId, SecurityPolicy.of(user, groups)).map(removed -> (removed ? Response.ok() : Response.status(Status.NOT_FOUND)).build()).orElseThrow(NotFoundException::new);
    }

    @GET
    @Path("/{id}/CPUAuthorize/{taskId}/attachments/{attachmentId}")
    @Produces(MediaType.APPLICATION_JSON)
    public Attachment getAttachment_CPUAuthorize_0(@PathParam("id") final String id, @PathParam("taskId") final String taskId, @PathParam("attachmentId") final String attachmentId, @QueryParam("user") final String user, @QueryParam("group") final List<String> groups) {
        return processService.getAttachment(process, id, taskId, attachmentId, SecurityPolicy.of(user, groups)).orElseThrow(() -> new NotFoundException("Attachment " + attachmentId + " not found"));
    }

    @GET
    @Path("/{id}/CPUAuthorize/{taskId}/attachments")
    @Produces(MediaType.APPLICATION_JSON)
    public Collection<Attachment> getAttachments_CPUAuthorize_0(@PathParam("id") final String id, @PathParam("taskId") final String taskId, @QueryParam("user") final String user, @QueryParam("group") final List<String> groups) {
        return processService.getAttachments(process, id, taskId, SecurityPolicy.of(user, groups)).orElseThrow(NotFoundException::new);
    }

    @GET
    @Path("/{id}/CPUAuthorize/{taskId}/comments/{commentId}")
    @Produces(MediaType.APPLICATION_JSON)
    public Comment getComment_CPUAuthorize_0(@PathParam("id") final String id, @PathParam("taskId") final String taskId, @PathParam("commentId") final String commentId, @QueryParam("user") final String user, @QueryParam("group") final List<String> groups) {
        return processService.getComment(process, id, taskId, commentId, SecurityPolicy.of(user, groups)).orElseThrow(() -> new NotFoundException("Comment " + commentId + " not found"));
    }

    @GET
    @Path("/{id}/CPUAuthorize/{taskId}/comments")
    @Produces(MediaType.APPLICATION_JSON)
    public Collection<Comment> getComments_CPUAuthorize_0(@PathParam("id") final String id, @PathParam("taskId") final String taskId, @QueryParam("user") final String user, @QueryParam("group") final List<String> groups) {
        return processService.getComments(process, id, taskId, SecurityPolicy.of(user, groups)).orElseThrow(NotFoundException::new);
    }

    @POST
    @Path("/{id}/CPUReview/{taskId}")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Account_opening_workflowModelOutput completeTask_CPUReview_1(@PathParam("id") final String id, @PathParam("taskId") final String taskId, @QueryParam("phase") @DefaultValue("complete") final String phase, @QueryParam("user") final String user, @QueryParam("group") final List<String> groups, final com.example.Account_opening_workflow_5_TaskOutput model) {
        return processService.taskTransition(process, id, taskId, phase, SecurityPolicy.of(user, groups), model).orElseThrow(NotFoundException::new);
    }

    @PUT
    @Path("/{id}/CPUReview/{taskId}")
    @Consumes(MediaType.APPLICATION_JSON)
    public com.example.Account_opening_workflow_5_TaskOutput saveTask_CPUReview_1(@PathParam("id") final String id, @PathParam("taskId") final String taskId, @QueryParam("user") final String user, @QueryParam("group") final List<String> groups, final com.example.Account_opening_workflow_5_TaskOutput model) {
        return processService.saveTask(process, id, taskId, SecurityPolicy.of(user, groups), model, com.example.Account_opening_workflow_5_TaskOutput::fromMap).orElseThrow(NotFoundException::new);
    }

    @POST
    @Path("/{id}/CPUReview/{taskId}/phases/{phase}")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Account_opening_workflowModelOutput taskTransition_CPUReview_1(@PathParam("id") final String id, @PathParam("taskId") final String taskId, @PathParam("phase") final String phase, @QueryParam("user") final String user, @QueryParam("group") final List<String> groups, final com.example.Account_opening_workflow_5_TaskOutput model) {
        return processService.taskTransition(process, id, taskId, phase, SecurityPolicy.of(user, groups), model).orElseThrow(NotFoundException::new);
    }

    @GET
    @Path("/{id}/CPUReview/{taskId}")
    @Produces(MediaType.APPLICATION_JSON)
    public com.example.Account_opening_workflow_5_TaskModel getTask_CPUReview_1(@PathParam("id") String id, @PathParam("taskId") String taskId, @QueryParam("user") final String user, @QueryParam("group") final List<String> groups) {
        return processService.getTask(process, id, taskId, SecurityPolicy.of(user, groups), com.example.Account_opening_workflow_5_TaskModel::from).orElseThrow(NotFoundException::new);
    }

    @DELETE
    @Path("/{id}/CPUReview/{taskId}")
    @Produces(MediaType.APPLICATION_JSON)
    public Account_opening_workflowModelOutput abortTask_CPUReview_1(@PathParam("id") final String id, @PathParam("taskId") final String taskId, @QueryParam("phase") @DefaultValue("abort") final String phase, @QueryParam("user") final String user, @QueryParam("group") final List<String> groups) {
        return processService.taskTransition(process, id, taskId, phase, SecurityPolicy.of(user, groups), null).orElseThrow(NotFoundException::new);
    }

    @GET
    @Path("CPUReview/schema")
    @Produces(MediaType.APPLICATION_JSON)
    public Map<String, Object> getSchema_CPUReview_1() {
        return JsonSchemaUtil.load(this.getClass().getClassLoader(), process.id(), "CPUReview");
    }

    @GET
    @Path("/{id}/CPUReview/{taskId}/schema")
    @Produces(MediaType.APPLICATION_JSON)
    public Map<String, Object> getSchemaAndPhases_CPUReview_1(@PathParam("id") final String id, @PathParam("taskId") final String taskId, @QueryParam("user") final String user, @QueryParam("group") final List<String> groups) {
        return processService.getSchemaAndPhases(process, id, taskId, "CPUReview", SecurityPolicy.of(user, groups));
    }

    @POST
    @Path("/{id}/CPUReview/{taskId}/comments")
    @Consumes(MediaType.TEXT_PLAIN)
    @Produces(MediaType.APPLICATION_JSON)
    public Response addComment_CPUReview_1(@PathParam("id") final String id, @PathParam("taskId") final String taskId, @QueryParam("user") final String user, @QueryParam("group") final List<String> groups, String commentInfo, @Context UriInfo uriInfo) {
        return processService.addComment(process, id, taskId, SecurityPolicy.of(user, groups), commentInfo).map(comment -> Response.created(uriInfo.getAbsolutePathBuilder().path(comment.getId().toString()).build()).entity(comment).build()).orElseThrow(NotFoundException::new);
    }

    @PUT
    @Path("/{id}/CPUReview/{taskId}/comments/{commentId}")
    @Consumes(MediaType.TEXT_PLAIN)
    @Produces(MediaType.APPLICATION_JSON)
    public Comment updateComment_CPUReview_1(@PathParam("id") final String id, @PathParam("taskId") final String taskId, @PathParam("commentId") final String commentId, @QueryParam("user") final String user, @QueryParam("group") final List<String> groups, String comment) {
        return processService.updateComment(process, id, taskId, commentId, SecurityPolicy.of(user, groups), comment).orElseThrow(NotFoundException::new);
    }

    @DELETE
    @Path("/{id}/CPUReview/{taskId}/comments/{commentId}")
    public Response deleteComment_CPUReview_1(@PathParam("id") final String id, @PathParam("taskId") final String taskId, @PathParam("commentId") final String commentId, @QueryParam("user") final String user, @QueryParam("group") final List<String> groups) {
        return processService.deleteComment(process, id, taskId, commentId, SecurityPolicy.of(user, groups)).map(removed -> (removed ? Response.ok() : Response.status(Status.NOT_FOUND)).build()).orElseThrow(NotFoundException::new);
    }

    @POST
    @Path("/{id}/CPUReview/{taskId}/attachments")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response addAttachment_CPUReview_1(@PathParam("id") final String id, @PathParam("taskId") final String taskId, @QueryParam("user") final String user, @QueryParam("group") final List<String> groups, AttachmentInfo attachmentInfo, @Context UriInfo uriInfo) {
        return processService.addAttachment(process, id, taskId, SecurityPolicy.of(user, groups), attachmentInfo).map(attachment -> Response.created(uriInfo.getAbsolutePathBuilder().path(attachment.getId().toString()).build()).entity(attachment).build()).orElseThrow(NotFoundException::new);
    }

    @PUT
    @Path("/{id}/CPUReview/{taskId}/attachments/{attachmentId}")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Attachment updateAttachment_CPUReview_1(@PathParam("id") final String id, @PathParam("taskId") final String taskId, @PathParam("attachmentId") final String attachmentId, @QueryParam("user") final String user, @QueryParam("group") final List<String> groups, AttachmentInfo attachment) {
        return processService.updateAttachment(process, id, taskId, attachmentId, SecurityPolicy.of(user, groups), attachment).orElseThrow(NotFoundException::new);
    }

    @DELETE
    @Path("/{id}/CPUReview/{taskId}/attachments/{attachmentId}")
    public Response deleteAttachment_CPUReview_1(@PathParam("id") final String id, @PathParam("taskId") final String taskId, @PathParam("attachmentId") final String attachmentId, @QueryParam("user") final String user, @QueryParam("group") final List<String> groups) {
        return processService.deleteAttachment(process, id, taskId, attachmentId, SecurityPolicy.of(user, groups)).map(removed -> (removed ? Response.ok() : Response.status(Status.NOT_FOUND)).build()).orElseThrow(NotFoundException::new);
    }

    @GET
    @Path("/{id}/CPUReview/{taskId}/attachments/{attachmentId}")
    @Produces(MediaType.APPLICATION_JSON)
    public Attachment getAttachment_CPUReview_1(@PathParam("id") final String id, @PathParam("taskId") final String taskId, @PathParam("attachmentId") final String attachmentId, @QueryParam("user") final String user, @QueryParam("group") final List<String> groups) {
        return processService.getAttachment(process, id, taskId, attachmentId, SecurityPolicy.of(user, groups)).orElseThrow(() -> new NotFoundException("Attachment " + attachmentId + " not found"));
    }

    @GET
    @Path("/{id}/CPUReview/{taskId}/attachments")
    @Produces(MediaType.APPLICATION_JSON)
    public Collection<Attachment> getAttachments_CPUReview_1(@PathParam("id") final String id, @PathParam("taskId") final String taskId, @QueryParam("user") final String user, @QueryParam("group") final List<String> groups) {
        return processService.getAttachments(process, id, taskId, SecurityPolicy.of(user, groups)).orElseThrow(NotFoundException::new);
    }

    @GET
    @Path("/{id}/CPUReview/{taskId}/comments/{commentId}")
    @Produces(MediaType.APPLICATION_JSON)
    public Comment getComment_CPUReview_1(@PathParam("id") final String id, @PathParam("taskId") final String taskId, @PathParam("commentId") final String commentId, @QueryParam("user") final String user, @QueryParam("group") final List<String> groups) {
        return processService.getComment(process, id, taskId, commentId, SecurityPolicy.of(user, groups)).orElseThrow(() -> new NotFoundException("Comment " + commentId + " not found"));
    }

    @GET
    @Path("/{id}/CPUReview/{taskId}/comments")
    @Produces(MediaType.APPLICATION_JSON)
    public Collection<Comment> getComments_CPUReview_1(@PathParam("id") final String id, @PathParam("taskId") final String taskId, @QueryParam("user") final String user, @QueryParam("group") final List<String> groups) {
        return processService.getComments(process, id, taskId, SecurityPolicy.of(user, groups)).orElseThrow(NotFoundException::new);
    }

    @POST
    @Path("/{id}/Approval/{taskId}")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Account_opening_workflowModelOutput completeTask_Approval_2(@PathParam("id") final String id, @PathParam("taskId") final String taskId, @QueryParam("phase") @DefaultValue("complete") final String phase, @QueryParam("user") final String user, @QueryParam("group") final List<String> groups, final com.example.Account_opening_workflow_7_TaskOutput model) {
        return processService.taskTransition(process, id, taskId, phase, SecurityPolicy.of(user, groups), model).orElseThrow(NotFoundException::new);
    }

    @PUT
    @Path("/{id}/Approval/{taskId}")
    @Consumes(MediaType.APPLICATION_JSON)
    public com.example.Account_opening_workflow_7_TaskOutput saveTask_Approval_2(@PathParam("id") final String id, @PathParam("taskId") final String taskId, @QueryParam("user") final String user, @QueryParam("group") final List<String> groups, final com.example.Account_opening_workflow_7_TaskOutput model) {
        return processService.saveTask(process, id, taskId, SecurityPolicy.of(user, groups), model, com.example.Account_opening_workflow_7_TaskOutput::fromMap).orElseThrow(NotFoundException::new);
    }

    @POST
    @Path("/{id}/Approval/{taskId}/phases/{phase}")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Account_opening_workflowModelOutput taskTransition_Approval_2(@PathParam("id") final String id, @PathParam("taskId") final String taskId, @PathParam("phase") final String phase, @QueryParam("user") final String user, @QueryParam("group") final List<String> groups, final com.example.Account_opening_workflow_7_TaskOutput model) {
        return processService.taskTransition(process, id, taskId, phase, SecurityPolicy.of(user, groups), model).orElseThrow(NotFoundException::new);
    }

    @GET
    @Path("/{id}/Approval/{taskId}")
    @Produces(MediaType.APPLICATION_JSON)
    public com.example.Account_opening_workflow_7_TaskModel getTask_Approval_2(@PathParam("id") String id, @PathParam("taskId") String taskId, @QueryParam("user") final String user, @QueryParam("group") final List<String> groups) {
        return processService.getTask(process, id, taskId, SecurityPolicy.of(user, groups), com.example.Account_opening_workflow_7_TaskModel::from).orElseThrow(NotFoundException::new);
    }

    @DELETE
    @Path("/{id}/Approval/{taskId}")
    @Produces(MediaType.APPLICATION_JSON)
    public Account_opening_workflowModelOutput abortTask_Approval_2(@PathParam("id") final String id, @PathParam("taskId") final String taskId, @QueryParam("phase") @DefaultValue("abort") final String phase, @QueryParam("user") final String user, @QueryParam("group") final List<String> groups) {
        return processService.taskTransition(process, id, taskId, phase, SecurityPolicy.of(user, groups), null).orElseThrow(NotFoundException::new);
    }

    @GET
    @Path("Approval/schema")
    @Produces(MediaType.APPLICATION_JSON)
    public Map<String, Object> getSchema_Approval_2() {
        return JsonSchemaUtil.load(this.getClass().getClassLoader(), process.id(), "Approval");
    }

    @GET
    @Path("/{id}/Approval/{taskId}/schema")
    @Produces(MediaType.APPLICATION_JSON)
    public Map<String, Object> getSchemaAndPhases_Approval_2(@PathParam("id") final String id, @PathParam("taskId") final String taskId, @QueryParam("user") final String user, @QueryParam("group") final List<String> groups) {
        return processService.getSchemaAndPhases(process, id, taskId, "Approval", SecurityPolicy.of(user, groups));
    }

    @POST
    @Path("/{id}/Approval/{taskId}/comments")
    @Consumes(MediaType.TEXT_PLAIN)
    @Produces(MediaType.APPLICATION_JSON)
    public Response addComment_Approval_2(@PathParam("id") final String id, @PathParam("taskId") final String taskId, @QueryParam("user") final String user, @QueryParam("group") final List<String> groups, String commentInfo, @Context UriInfo uriInfo) {
        return processService.addComment(process, id, taskId, SecurityPolicy.of(user, groups), commentInfo).map(comment -> Response.created(uriInfo.getAbsolutePathBuilder().path(comment.getId().toString()).build()).entity(comment).build()).orElseThrow(NotFoundException::new);
    }

    @PUT
    @Path("/{id}/Approval/{taskId}/comments/{commentId}")
    @Consumes(MediaType.TEXT_PLAIN)
    @Produces(MediaType.APPLICATION_JSON)
    public Comment updateComment_Approval_2(@PathParam("id") final String id, @PathParam("taskId") final String taskId, @PathParam("commentId") final String commentId, @QueryParam("user") final String user, @QueryParam("group") final List<String> groups, String comment) {
        return processService.updateComment(process, id, taskId, commentId, SecurityPolicy.of(user, groups), comment).orElseThrow(NotFoundException::new);
    }

    @DELETE
    @Path("/{id}/Approval/{taskId}/comments/{commentId}")
    public Response deleteComment_Approval_2(@PathParam("id") final String id, @PathParam("taskId") final String taskId, @PathParam("commentId") final String commentId, @QueryParam("user") final String user, @QueryParam("group") final List<String> groups) {
        return processService.deleteComment(process, id, taskId, commentId, SecurityPolicy.of(user, groups)).map(removed -> (removed ? Response.ok() : Response.status(Status.NOT_FOUND)).build()).orElseThrow(NotFoundException::new);
    }

    @POST
    @Path("/{id}/Approval/{taskId}/attachments")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response addAttachment_Approval_2(@PathParam("id") final String id, @PathParam("taskId") final String taskId, @QueryParam("user") final String user, @QueryParam("group") final List<String> groups, AttachmentInfo attachmentInfo, @Context UriInfo uriInfo) {
        return processService.addAttachment(process, id, taskId, SecurityPolicy.of(user, groups), attachmentInfo).map(attachment -> Response.created(uriInfo.getAbsolutePathBuilder().path(attachment.getId().toString()).build()).entity(attachment).build()).orElseThrow(NotFoundException::new);
    }

    @PUT
    @Path("/{id}/Approval/{taskId}/attachments/{attachmentId}")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Attachment updateAttachment_Approval_2(@PathParam("id") final String id, @PathParam("taskId") final String taskId, @PathParam("attachmentId") final String attachmentId, @QueryParam("user") final String user, @QueryParam("group") final List<String> groups, AttachmentInfo attachment) {
        return processService.updateAttachment(process, id, taskId, attachmentId, SecurityPolicy.of(user, groups), attachment).orElseThrow(NotFoundException::new);
    }

    @DELETE
    @Path("/{id}/Approval/{taskId}/attachments/{attachmentId}")
    public Response deleteAttachment_Approval_2(@PathParam("id") final String id, @PathParam("taskId") final String taskId, @PathParam("attachmentId") final String attachmentId, @QueryParam("user") final String user, @QueryParam("group") final List<String> groups) {
        return processService.deleteAttachment(process, id, taskId, attachmentId, SecurityPolicy.of(user, groups)).map(removed -> (removed ? Response.ok() : Response.status(Status.NOT_FOUND)).build()).orElseThrow(NotFoundException::new);
    }

    @GET
    @Path("/{id}/Approval/{taskId}/attachments/{attachmentId}")
    @Produces(MediaType.APPLICATION_JSON)
    public Attachment getAttachment_Approval_2(@PathParam("id") final String id, @PathParam("taskId") final String taskId, @PathParam("attachmentId") final String attachmentId, @QueryParam("user") final String user, @QueryParam("group") final List<String> groups) {
        return processService.getAttachment(process, id, taskId, attachmentId, SecurityPolicy.of(user, groups)).orElseThrow(() -> new NotFoundException("Attachment " + attachmentId + " not found"));
    }

    @GET
    @Path("/{id}/Approval/{taskId}/attachments")
    @Produces(MediaType.APPLICATION_JSON)
    public Collection<Attachment> getAttachments_Approval_2(@PathParam("id") final String id, @PathParam("taskId") final String taskId, @QueryParam("user") final String user, @QueryParam("group") final List<String> groups) {
        return processService.getAttachments(process, id, taskId, SecurityPolicy.of(user, groups)).orElseThrow(NotFoundException::new);
    }

    @GET
    @Path("/{id}/Approval/{taskId}/comments/{commentId}")
    @Produces(MediaType.APPLICATION_JSON)
    public Comment getComment_Approval_2(@PathParam("id") final String id, @PathParam("taskId") final String taskId, @PathParam("commentId") final String commentId, @QueryParam("user") final String user, @QueryParam("group") final List<String> groups) {
        return processService.getComment(process, id, taskId, commentId, SecurityPolicy.of(user, groups)).orElseThrow(() -> new NotFoundException("Comment " + commentId + " not found"));
    }

    @GET
    @Path("/{id}/Approval/{taskId}/comments")
    @Produces(MediaType.APPLICATION_JSON)
    public Collection<Comment> getComments_Approval_2(@PathParam("id") final String id, @PathParam("taskId") final String taskId, @QueryParam("user") final String user, @QueryParam("group") final List<String> groups) {
        return processService.getComments(process, id, taskId, SecurityPolicy.of(user, groups)).orElseThrow(NotFoundException::new);
    }

    @POST
    @Path("/{id}/DataEntry/{taskId}")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Account_opening_workflowModelOutput completeTask_DataEntry_3(@PathParam("id") final String id, @PathParam("taskId") final String taskId, @QueryParam("phase") @DefaultValue("complete") final String phase, @QueryParam("user") final String user, @QueryParam("group") final List<String> groups, final com.example.Account_opening_workflow_8_TaskOutput model) {
        return processService.taskTransition(process, id, taskId, phase, SecurityPolicy.of(user, groups), model).orElseThrow(NotFoundException::new);
    }

    @PUT
    @Path("/{id}/DataEntry/{taskId}")
    @Consumes(MediaType.APPLICATION_JSON)
    public com.example.Account_opening_workflow_8_TaskOutput saveTask_DataEntry_3(@PathParam("id") final String id, @PathParam("taskId") final String taskId, @QueryParam("user") final String user, @QueryParam("group") final List<String> groups, final com.example.Account_opening_workflow_8_TaskOutput model) {
        return processService.saveTask(process, id, taskId, SecurityPolicy.of(user, groups), model, com.example.Account_opening_workflow_8_TaskOutput::fromMap).orElseThrow(NotFoundException::new);
    }

    @POST
    @Path("/{id}/DataEntry/{taskId}/phases/{phase}")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Account_opening_workflowModelOutput taskTransition_DataEntry_3(@PathParam("id") final String id, @PathParam("taskId") final String taskId, @PathParam("phase") final String phase, @QueryParam("user") final String user, @QueryParam("group") final List<String> groups, final com.example.Account_opening_workflow_8_TaskOutput model) {
        return processService.taskTransition(process, id, taskId, phase, SecurityPolicy.of(user, groups), model).orElseThrow(NotFoundException::new);
    }

    @GET
    @Path("/{id}/DataEntry/{taskId}")
    @Produces(MediaType.APPLICATION_JSON)
    public com.example.Account_opening_workflow_8_TaskModel getTask_DataEntry_3(@PathParam("id") String id, @PathParam("taskId") String taskId, @QueryParam("user") final String user, @QueryParam("group") final List<String> groups) {
        return processService.getTask(process, id, taskId, SecurityPolicy.of(user, groups), com.example.Account_opening_workflow_8_TaskModel::from).orElseThrow(NotFoundException::new);
    }

    @DELETE
    @Path("/{id}/DataEntry/{taskId}")
    @Produces(MediaType.APPLICATION_JSON)
    public Account_opening_workflowModelOutput abortTask_DataEntry_3(@PathParam("id") final String id, @PathParam("taskId") final String taskId, @QueryParam("phase") @DefaultValue("abort") final String phase, @QueryParam("user") final String user, @QueryParam("group") final List<String> groups) {
        return processService.taskTransition(process, id, taskId, phase, SecurityPolicy.of(user, groups), null).orElseThrow(NotFoundException::new);
    }

    @GET
    @Path("DataEntry/schema")
    @Produces(MediaType.APPLICATION_JSON)
    public Map<String, Object> getSchema_DataEntry_3() {
        return JsonSchemaUtil.load(this.getClass().getClassLoader(), process.id(), "DataEntry");
    }

    @GET
    @Path("/{id}/DataEntry/{taskId}/schema")
    @Produces(MediaType.APPLICATION_JSON)
    public Map<String, Object> getSchemaAndPhases_DataEntry_3(@PathParam("id") final String id, @PathParam("taskId") final String taskId, @QueryParam("user") final String user, @QueryParam("group") final List<String> groups) {
        return processService.getSchemaAndPhases(process, id, taskId, "DataEntry", SecurityPolicy.of(user, groups));
    }

    @POST
    @Path("/{id}/DataEntry/{taskId}/comments")
    @Consumes(MediaType.TEXT_PLAIN)
    @Produces(MediaType.APPLICATION_JSON)
    public Response addComment_DataEntry_3(@PathParam("id") final String id, @PathParam("taskId") final String taskId, @QueryParam("user") final String user, @QueryParam("group") final List<String> groups, String commentInfo, @Context UriInfo uriInfo) {
        return processService.addComment(process, id, taskId, SecurityPolicy.of(user, groups), commentInfo).map(comment -> Response.created(uriInfo.getAbsolutePathBuilder().path(comment.getId().toString()).build()).entity(comment).build()).orElseThrow(NotFoundException::new);
    }

    @PUT
    @Path("/{id}/DataEntry/{taskId}/comments/{commentId}")
    @Consumes(MediaType.TEXT_PLAIN)
    @Produces(MediaType.APPLICATION_JSON)
    public Comment updateComment_DataEntry_3(@PathParam("id") final String id, @PathParam("taskId") final String taskId, @PathParam("commentId") final String commentId, @QueryParam("user") final String user, @QueryParam("group") final List<String> groups, String comment) {
        return processService.updateComment(process, id, taskId, commentId, SecurityPolicy.of(user, groups), comment).orElseThrow(NotFoundException::new);
    }

    @DELETE
    @Path("/{id}/DataEntry/{taskId}/comments/{commentId}")
    public Response deleteComment_DataEntry_3(@PathParam("id") final String id, @PathParam("taskId") final String taskId, @PathParam("commentId") final String commentId, @QueryParam("user") final String user, @QueryParam("group") final List<String> groups) {
        return processService.deleteComment(process, id, taskId, commentId, SecurityPolicy.of(user, groups)).map(removed -> (removed ? Response.ok() : Response.status(Status.NOT_FOUND)).build()).orElseThrow(NotFoundException::new);
    }

    @POST
    @Path("/{id}/DataEntry/{taskId}/attachments")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response addAttachment_DataEntry_3(@PathParam("id") final String id, @PathParam("taskId") final String taskId, @QueryParam("user") final String user, @QueryParam("group") final List<String> groups, AttachmentInfo attachmentInfo, @Context UriInfo uriInfo) {
        return processService.addAttachment(process, id, taskId, SecurityPolicy.of(user, groups), attachmentInfo).map(attachment -> Response.created(uriInfo.getAbsolutePathBuilder().path(attachment.getId().toString()).build()).entity(attachment).build()).orElseThrow(NotFoundException::new);
    }

    @PUT
    @Path("/{id}/DataEntry/{taskId}/attachments/{attachmentId}")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Attachment updateAttachment_DataEntry_3(@PathParam("id") final String id, @PathParam("taskId") final String taskId, @PathParam("attachmentId") final String attachmentId, @QueryParam("user") final String user, @QueryParam("group") final List<String> groups, AttachmentInfo attachment) {
        return processService.updateAttachment(process, id, taskId, attachmentId, SecurityPolicy.of(user, groups), attachment).orElseThrow(NotFoundException::new);
    }

    @DELETE
    @Path("/{id}/DataEntry/{taskId}/attachments/{attachmentId}")
    public Response deleteAttachment_DataEntry_3(@PathParam("id") final String id, @PathParam("taskId") final String taskId, @PathParam("attachmentId") final String attachmentId, @QueryParam("user") final String user, @QueryParam("group") final List<String> groups) {
        return processService.deleteAttachment(process, id, taskId, attachmentId, SecurityPolicy.of(user, groups)).map(removed -> (removed ? Response.ok() : Response.status(Status.NOT_FOUND)).build()).orElseThrow(NotFoundException::new);
    }

    @GET
    @Path("/{id}/DataEntry/{taskId}/attachments/{attachmentId}")
    @Produces(MediaType.APPLICATION_JSON)
    public Attachment getAttachment_DataEntry_3(@PathParam("id") final String id, @PathParam("taskId") final String taskId, @PathParam("attachmentId") final String attachmentId, @QueryParam("user") final String user, @QueryParam("group") final List<String> groups) {
        return processService.getAttachment(process, id, taskId, attachmentId, SecurityPolicy.of(user, groups)).orElseThrow(() -> new NotFoundException("Attachment " + attachmentId + " not found"));
    }

    @GET
    @Path("/{id}/DataEntry/{taskId}/attachments")
    @Produces(MediaType.APPLICATION_JSON)
    public Collection<Attachment> getAttachments_DataEntry_3(@PathParam("id") final String id, @PathParam("taskId") final String taskId, @QueryParam("user") final String user, @QueryParam("group") final List<String> groups) {
        return processService.getAttachments(process, id, taskId, SecurityPolicy.of(user, groups)).orElseThrow(NotFoundException::new);
    }

    @GET
    @Path("/{id}/DataEntry/{taskId}/comments/{commentId}")
    @Produces(MediaType.APPLICATION_JSON)
    public Comment getComment_DataEntry_3(@PathParam("id") final String id, @PathParam("taskId") final String taskId, @PathParam("commentId") final String commentId, @QueryParam("user") final String user, @QueryParam("group") final List<String> groups) {
        return processService.getComment(process, id, taskId, commentId, SecurityPolicy.of(user, groups)).orElseThrow(() -> new NotFoundException("Comment " + commentId + " not found"));
    }

    @GET
    @Path("/{id}/DataEntry/{taskId}/comments")
    @Produces(MediaType.APPLICATION_JSON)
    public Collection<Comment> getComments_DataEntry_3(@PathParam("id") final String id, @PathParam("taskId") final String taskId, @QueryParam("user") final String user, @QueryParam("group") final List<String> groups) {
        return processService.getComments(process, id, taskId, SecurityPolicy.of(user, groups)).orElseThrow(NotFoundException::new);
    }
}
