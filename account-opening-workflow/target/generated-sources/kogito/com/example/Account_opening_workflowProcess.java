package com.example;

import com.example.Account_opening_workflowModel;
import org.kie.api.definition.process.Process;
import org.jbpm.ruleflow.core.RuleFlowProcessFactory;
import org.jbpm.process.core.datatype.impl.type.ObjectDataType;
import org.drools.core.util.KieFunctions;
import org.jbpm.process.core.datatype.impl.type.StringDataType;

@javax.enterprise.context.ApplicationScoped()
@javax.inject.Named("account_opening_workflow")
@io.quarkus.runtime.Startup()
public class Account_opening_workflowProcess extends org.kie.kogito.process.impl.AbstractProcess<com.example.Account_opening_workflowModel> {

    public Account_opening_workflowProcess(org.kie.kogito.app.Application app, org.kie.kogito.correlation.CorrelationService correlations) {
        this(app, correlations, new org.kie.kogito.handlers.ServiceRoute_accountOpenStatus_3_Handler(), new org.kie.kogito.handlers.ServiceRoute_accountOpen_6_Handler());
    }

    @javax.inject.Inject()
    public Account_opening_workflowProcess(org.kie.kogito.app.Application app, org.kie.kogito.correlation.CorrelationService correlations, org.kie.kogito.handlers.ServiceRoute_accountOpenStatus_3_Handler serviceRoute_accountOpenStatus_3_Handler, org.kie.kogito.handlers.ServiceRoute_accountOpen_6_Handler serviceRoute_accountOpen_6_Handler) {
        super(app, java.util.Arrays.asList(serviceRoute_accountOpenStatus_3_Handler, serviceRoute_accountOpen_6_Handler), correlations);
        activate();
    }

    public Account_opening_workflowProcess() {
    }

    @Override()
    public com.example.Account_opening_workflowProcessInstance createInstance(com.example.Account_opening_workflowModel value) {
        return new com.example.Account_opening_workflowProcessInstance(this, value, this.createProcessRuntime());
    }

    public com.example.Account_opening_workflowProcessInstance createInstance(java.lang.String businessKey, com.example.Account_opening_workflowModel value) {
        return new com.example.Account_opening_workflowProcessInstance(this, value, businessKey, this.createProcessRuntime());
    }

    public com.example.Account_opening_workflowProcessInstance createInstance(java.lang.String businessKey, org.kie.kogito.correlation.CompositeCorrelation correlation, com.example.Account_opening_workflowModel value) {
        return new com.example.Account_opening_workflowProcessInstance(this, value, businessKey, this.createProcessRuntime(), correlation);
    }

    @Override()
    public com.example.Account_opening_workflowModel createModel() {
        return new com.example.Account_opening_workflowModel();
    }

    public com.example.Account_opening_workflowProcessInstance createInstance(org.kie.kogito.Model value) {
        return this.createInstance((com.example.Account_opening_workflowModel) value);
    }

    public com.example.Account_opening_workflowProcessInstance createInstance(java.lang.String businessKey, org.kie.kogito.Model value) {
        return this.createInstance(businessKey, (com.example.Account_opening_workflowModel) value);
    }

    public com.example.Account_opening_workflowProcessInstance createInstance(org.kie.api.runtime.process.WorkflowProcessInstance wpi) {
        return new com.example.Account_opening_workflowProcessInstance(this, this.createModel(), this.createProcessRuntime(), wpi);
    }

    public com.example.Account_opening_workflowProcessInstance createReadOnlyInstance(org.kie.api.runtime.process.WorkflowProcessInstance wpi) {
        return new com.example.Account_opening_workflowProcessInstance(this, this.createModel(), wpi);
    }

    protected org.kie.api.definition.process.Process process() {
        RuleFlowProcessFactory factory = RuleFlowProcessFactory.createProcess("account_opening_workflow", true);
        factory.variable("accountnumber", org.jbpm.process.core.datatype.DataTypeResolver.fromClass(java.lang.String.class), null, "customTags", null);
        factory.variable("result", org.jbpm.process.core.datatype.DataTypeResolver.fromClass(java.lang.String.class), null, "customTags", null);
        factory.name("account-opening-workflow");
        factory.packageName("com.example");
        factory.dynamic(false);
        factory.version("1.0");
        factory.type("BPMN");
        factory.visibility("Public");
        factory.metaData("TargetNamespace", "http://www.omg.org/bpmn20");
        org.jbpm.ruleflow.core.factory.HumanTaskNodeFactory<?> humanTaskNode1 = factory.humanTaskNode(1);
        humanTaskNode1.name("CPU Authorize");
        humanTaskNode1.workParameter("NodeName", "CPU Authorize");
        humanTaskNode1.workParameter("TaskName", "CPUAuthorize");
        humanTaskNode1.workParameter("Skippable", "false");
        humanTaskNode1.mapDataInputAssociation(new org.jbpm.workflow.core.impl.DataAssociation(java.util.Arrays.asList(), new org.jbpm.workflow.core.impl.DataDefinition("_B7B54C29-F8AD-4620-A353-DB15EC89C19D_TaskNameInputX", "TaskName", "Object", null), java.util.Arrays.asList(new org.jbpm.workflow.core.node.Assignment(null, new org.jbpm.workflow.core.impl.DataDefinition("76946d18-e070-45ff-945f-aa4ddd8820b2", "EXPRESSION (CPUAuthorize)", "java.lang.Object", "CPUAuthorize"), new org.jbpm.workflow.core.impl.DataDefinition("_B7B54C29-F8AD-4620-A353-DB15EC89C19D_TaskNameInputX", "TaskName", "Object", null))), null));
        humanTaskNode1.mapDataInputAssociation(new org.jbpm.workflow.core.impl.DataAssociation(java.util.Arrays.asList(), new org.jbpm.workflow.core.impl.DataDefinition("_B7B54C29-F8AD-4620-A353-DB15EC89C19D_SkippableInputX", "Skippable", "Object", null), java.util.Arrays.asList(new org.jbpm.workflow.core.node.Assignment(null, new org.jbpm.workflow.core.impl.DataDefinition("e69c82b8-e34f-44f5-abf6-da6216d292c4", "EXPRESSION (false)", "java.lang.Object", "false"), new org.jbpm.workflow.core.impl.DataDefinition("_B7B54C29-F8AD-4620-A353-DB15EC89C19D_SkippableInputX", "Skippable", "Object", null))), null));
        humanTaskNode1.done();
        humanTaskNode1.metaData("UniqueId", "_B7B54C29-F8AD-4620-A353-DB15EC89C19D");
        humanTaskNode1.metaData("elementname", "CPU Authorize");
        humanTaskNode1.metaData("Documentation", "CPU Authorize");
        humanTaskNode1.metaData("x", 1377);
        humanTaskNode1.metaData("width", 154);
        humanTaskNode1.metaData("y", 144);
        humanTaskNode1.metaData("height", 102);
        org.jbpm.ruleflow.core.factory.EndNodeFactory<?> endNode2 = factory.endNode(2);
        endNode2.name("End");
        endNode2.terminate(false);
        endNode2.metaData("UniqueId", "_E5D9C32E-8DA6-4F3C-AC6A-43A613CF2BE9");
        endNode2.metaData("elementname", "End");
        endNode2.metaData("x", 1967);
        endNode2.metaData("width", 56);
        endNode2.metaData("y", 167);
        endNode2.metaData("height", 56);
        endNode2.done();
        org.jbpm.ruleflow.core.factory.WorkItemNodeFactory<?> workItemNode3 = factory.workItemNode(3);
        workItemNode3.name("Account Generate and Update");
        workItemNode3.workName("apps.account.ServiceRoute_accountOpenStatus_3_Handler");
        workItemNode3.workParameter("NodeName", "Account Generate and Update");
        workItemNode3.workParameter("Interface", "apps.account.ServiceRoute");
        workItemNode3.workParameter("Operation", "accountOpenStatus");
        workItemNode3.workParameter("interfaceImplementationRef", "apps.account.ServiceRoute");
        workItemNode3.workParameter("operationImplementationRef", "accountOpenStatus");
        workItemNode3.workParameter("implementation", "Java");
        workItemNode3.done();
        workItemNode3.metaData("UniqueId", "_A7D6D4A3-7F0E-4645-83C0-F63635D9C2A0");
        workItemNode3.metaData("Implementation", "Java");
        workItemNode3.metaData("elementname", "Account Generate and Update");
        workItemNode3.metaData("Type", "Service Task");
        workItemNode3.metaData("OperationRef", "_A7D6D4A3-7F0E-4645-83C0-F63635D9C2A0_ServiceOperation");
        workItemNode3.metaData("x", 1733);
        workItemNode3.metaData("width", 154);
        workItemNode3.metaData("y", 144);
        workItemNode3.metaData("height", 102);
        org.jbpm.ruleflow.core.factory.SplitFactory<?> splitNode4 = factory.splitNode(4);
        splitNode4.name("Split");
        splitNode4.type(2);
        splitNode4.metaData("UniqueId", "_DC407BCE-2C70-416C-B136-6AADF2AF073D");
        splitNode4.metaData("x", 1604);
        splitNode4.metaData("width", 56);
        splitNode4.metaData("y", 167);
        splitNode4.metaData("Default", null);
        splitNode4.metaData("height", 56);
        splitNode4.constraint(9, "_A9F99217-49A1-4DDB-9D1A-563FAC94DBAA", "DROOLS_DEFAULT", "java", kcontext -> {
            java.lang.String accountnumber = (java.lang.String) kcontext.getVariable("accountnumber");
            java.lang.String result = (java.lang.String) kcontext.getVariable("result");
            return false;
        }, 0, false);
        splitNode4.constraint(3, "_78518A19-96D9-4C79-A6AB-C08F9FB33434", "DROOLS_DEFAULT", "java", kcontext -> {
            java.lang.String accountnumber = (java.lang.String) kcontext.getVariable("accountnumber");
            java.lang.String result = (java.lang.String) kcontext.getVariable("result");
            return true;
        }, 0, false);
        splitNode4.done();
        org.jbpm.ruleflow.core.factory.HumanTaskNodeFactory<?> humanTaskNode5 = factory.humanTaskNode(5);
        humanTaskNode5.name("CPU Review");
        humanTaskNode5.workParameter("NodeName", "CPU Review");
        humanTaskNode5.workParameter("TaskName", "CPUReview");
        humanTaskNode5.workParameter("Skippable", "false");
        humanTaskNode5.mapDataInputAssociation(new org.jbpm.workflow.core.impl.DataAssociation(java.util.Arrays.asList(), new org.jbpm.workflow.core.impl.DataDefinition("_C29E521D-A611-4E9A-AE88-D78B0FD447A5_TaskNameInputX", "TaskName", "Object", null), java.util.Arrays.asList(new org.jbpm.workflow.core.node.Assignment(null, new org.jbpm.workflow.core.impl.DataDefinition("37bd3540-b5c9-4d85-afb7-3683060b7097", "EXPRESSION (CPUReview)", "java.lang.Object", "CPUReview"), new org.jbpm.workflow.core.impl.DataDefinition("_C29E521D-A611-4E9A-AE88-D78B0FD447A5_TaskNameInputX", "TaskName", "Object", null))), null));
        humanTaskNode5.mapDataInputAssociation(new org.jbpm.workflow.core.impl.DataAssociation(java.util.Arrays.asList(), new org.jbpm.workflow.core.impl.DataDefinition("_C29E521D-A611-4E9A-AE88-D78B0FD447A5_SkippableInputX", "Skippable", "Object", null), java.util.Arrays.asList(new org.jbpm.workflow.core.node.Assignment(null, new org.jbpm.workflow.core.impl.DataDefinition("203b299d-e676-4126-923f-e5254675a923", "EXPRESSION (false)", "java.lang.Object", "false"), new org.jbpm.workflow.core.impl.DataDefinition("_C29E521D-A611-4E9A-AE88-D78B0FD447A5_SkippableInputX", "Skippable", "Object", null))), null));
        humanTaskNode5.done();
        humanTaskNode5.metaData("UniqueId", "_C29E521D-A611-4E9A-AE88-D78B0FD447A5");
        humanTaskNode5.metaData("elementname", "CPU Review");
        humanTaskNode5.metaData("x", 1143);
        humanTaskNode5.metaData("width", 154);
        humanTaskNode5.metaData("y", 144);
        humanTaskNode5.metaData("height", 102);
        org.jbpm.ruleflow.core.factory.WorkItemNodeFactory<?> workItemNode6 = factory.workItemNode(6);
        workItemNode6.name("Account Generate");
        workItemNode6.workName("apps.account.ServiceRoute_accountOpen_6_Handler");
        workItemNode6.workParameter("NodeName", "Account Generate");
        workItemNode6.workParameter("Interface", "apps.account.ServiceRoute");
        workItemNode6.workParameter("Operation", "accountOpen");
        workItemNode6.workParameter("interfaceImplementationRef", "apps.account.ServiceRoute");
        workItemNode6.workParameter("operationImplementationRef", "accountOpen");
        workItemNode6.workParameter("implementation", "Java");
        workItemNode6.mapDataInputAssociation(new org.jbpm.workflow.core.impl.DataAssociation(java.util.Arrays.asList(new org.jbpm.workflow.core.impl.DataDefinition("accountnumber", "accountnumber", "java.lang.Object", null)), new org.jbpm.workflow.core.impl.DataDefinition("_E01C132A-B50B-44A4-B0FE-339CCC162B50_accountnumberInputX", "accountnumber", "String", null), null, null));
        workItemNode6.mapDataInputAssociation(new org.jbpm.workflow.core.impl.DataAssociation(java.util.Arrays.asList(new org.jbpm.workflow.core.impl.DataDefinition("result", "result", "java.lang.Object", null)), new org.jbpm.workflow.core.impl.DataDefinition("_E01C132A-B50B-44A4-B0FE-339CCC162B50_resultInputX", "result", "String", null), null, null));
        workItemNode6.done();
        workItemNode6.metaData("UniqueId", "_E01C132A-B50B-44A4-B0FE-339CCC162B50");
        workItemNode6.metaData("Implementation", "Java");
        workItemNode6.metaData("elementname", "Account Generate");
        workItemNode6.metaData("Type", "Service Task");
        workItemNode6.metaData("OperationRef", "_E01C132A-B50B-44A4-B0FE-339CCC162B50_ServiceOperation");
        workItemNode6.metaData("x", 909);
        workItemNode6.metaData("width", 154);
        workItemNode6.metaData("y", 144);
        workItemNode6.metaData("height", 102);
        org.jbpm.ruleflow.core.factory.HumanTaskNodeFactory<?> humanTaskNode7 = factory.humanTaskNode(7);
        humanTaskNode7.name("Approval");
        humanTaskNode7.workParameter("NodeName", "Approval");
        humanTaskNode7.workParameter("TaskName", "Approval");
        humanTaskNode7.workParameter("Skippable", "false");
        humanTaskNode7.mapDataInputAssociation(new org.jbpm.workflow.core.impl.DataAssociation(java.util.Arrays.asList(), new org.jbpm.workflow.core.impl.DataDefinition("_916B1604-47A8-4EE5-AB1E-16A8C246A8D2_TaskNameInputX", "TaskName", "Object", null), java.util.Arrays.asList(new org.jbpm.workflow.core.node.Assignment(null, new org.jbpm.workflow.core.impl.DataDefinition("93c84b49-4349-4afc-9b1a-a71eb0673eef", "EXPRESSION (Approval)", "java.lang.Object", "Approval"), new org.jbpm.workflow.core.impl.DataDefinition("_916B1604-47A8-4EE5-AB1E-16A8C246A8D2_TaskNameInputX", "TaskName", "Object", null))), null));
        humanTaskNode7.mapDataInputAssociation(new org.jbpm.workflow.core.impl.DataAssociation(java.util.Arrays.asList(), new org.jbpm.workflow.core.impl.DataDefinition("_916B1604-47A8-4EE5-AB1E-16A8C246A8D2_SkippableInputX", "Skippable", "Object", null), java.util.Arrays.asList(new org.jbpm.workflow.core.node.Assignment(null, new org.jbpm.workflow.core.impl.DataDefinition("cbdadf80-f73c-43ba-8664-46d940a9a81c", "EXPRESSION (false)", "java.lang.Object", "false"), new org.jbpm.workflow.core.impl.DataDefinition("_916B1604-47A8-4EE5-AB1E-16A8C246A8D2_SkippableInputX", "Skippable", "Object", null))), null));
        humanTaskNode7.done();
        humanTaskNode7.metaData("UniqueId", "_916B1604-47A8-4EE5-AB1E-16A8C246A8D2");
        humanTaskNode7.metaData("elementname", "Approval");
        humanTaskNode7.metaData("x", 675);
        humanTaskNode7.metaData("width", 154);
        humanTaskNode7.metaData("y", 144);
        humanTaskNode7.metaData("height", 102);
        org.jbpm.ruleflow.core.factory.HumanTaskNodeFactory<?> humanTaskNode8 = factory.humanTaskNode(8);
        humanTaskNode8.name("DataEntry");
        humanTaskNode8.workParameter("NodeName", "DataEntry");
        humanTaskNode8.workParameter("TaskName", "DataEntry");
        humanTaskNode8.workParameter("Skippable", "false");
        humanTaskNode8.mapDataInputAssociation(new org.jbpm.workflow.core.impl.DataAssociation(java.util.Arrays.asList(), new org.jbpm.workflow.core.impl.DataDefinition("_FCE00BD4-D688-41FC-9C81-CAA0E4F1EA9D_TaskNameInputX", "TaskName", "Object", null), java.util.Arrays.asList(new org.jbpm.workflow.core.node.Assignment(null, new org.jbpm.workflow.core.impl.DataDefinition("65918c86-ae56-4a8b-abf2-333c29ea1276", "EXPRESSION (DataEntry)", "java.lang.Object", "DataEntry"), new org.jbpm.workflow.core.impl.DataDefinition("_FCE00BD4-D688-41FC-9C81-CAA0E4F1EA9D_TaskNameInputX", "TaskName", "Object", null))), null));
        humanTaskNode8.mapDataInputAssociation(new org.jbpm.workflow.core.impl.DataAssociation(java.util.Arrays.asList(), new org.jbpm.workflow.core.impl.DataDefinition("_FCE00BD4-D688-41FC-9C81-CAA0E4F1EA9D_SkippableInputX", "Skippable", "Object", null), java.util.Arrays.asList(new org.jbpm.workflow.core.node.Assignment(null, new org.jbpm.workflow.core.impl.DataDefinition("e9035da0-de78-4da8-9281-b9b80ec47fa6", "EXPRESSION (false)", "java.lang.Object", "false"), new org.jbpm.workflow.core.impl.DataDefinition("_FCE00BD4-D688-41FC-9C81-CAA0E4F1EA9D_SkippableInputX", "Skippable", "Object", null))), null));
        humanTaskNode8.done();
        humanTaskNode8.metaData("UniqueId", "_FCE00BD4-D688-41FC-9C81-CAA0E4F1EA9D");
        humanTaskNode8.metaData("elementname", "DataEntry");
        humanTaskNode8.metaData("x", 441);
        humanTaskNode8.metaData("width", 154);
        humanTaskNode8.metaData("y", 144);
        humanTaskNode8.metaData("height", 102);
        org.jbpm.ruleflow.core.factory.JoinFactory<?> joinNode9 = factory.joinNode(9);
        joinNode9.name("Join");
        joinNode9.type(2);
        joinNode9.metaData("UniqueId", "_A581981F-3DAB-42A2-BD2A-0EE5E6C6317B");
        joinNode9.metaData("x", 305);
        joinNode9.metaData("width", 56);
        joinNode9.metaData("y", 167);
        joinNode9.metaData("height", 56);
        joinNode9.done();
        org.jbpm.ruleflow.core.factory.StartNodeFactory<?> startNode10 = factory.startNode(10);
        startNode10.name("Start");
        startNode10.interrupting(true);
        startNode10.metaData("UniqueId", "_DDD1EE77-2EE7-46EB-B1DD-1BCD376DB9D3");
        startNode10.metaData("elementname", "Start");
        startNode10.metaData("x", 169);
        startNode10.metaData("width", 56);
        startNode10.metaData("y", 167);
        startNode10.metaData("height", 56);
        startNode10.done();
        factory.connection(5, 1, "_3264D199-340F-470F-A85E-0F7C77B7F278");
        factory.connection(3, 2, "_CFEE0AF6-9D63-4A17-8702-95F2B82FA4FD");
        factory.connection(4, 3, "_78518A19-96D9-4C79-A6AB-C08F9FB33434");
        factory.connection(1, 4, "_C62DEF87-F202-4A94-9172-3D2B0A41F60A");
        factory.connection(6, 5, "_5DF4DE57-E011-45BB-A275-1DCB891CC242");
        factory.connection(7, 6, "_22312397-5AC8-4712-B65A-68E052974663");
        factory.connection(8, 7, "_255789DB-9135-4D52-A8D9-476873C55972");
        factory.connection(9, 8, "_EBCD55C8-58D5-44F2-9E59-7CF7DF878D71");
        factory.connection(4, 9, "_A9F99217-49A1-4DDB-9D1A-563FAC94DBAA");
        factory.connection(10, 9, "_03856CAF-FA25-4CC1-8B11-7E2A7BAFEFBA");
        factory.validate();
        return factory.getProcess();
    }
}
