package com.example;

import com.example.Account_opening_workflowModel;

public class Account_opening_workflowProcessInstance extends org.kie.kogito.process.impl.AbstractProcessInstance<Account_opening_workflowModel> {

    public Account_opening_workflowProcessInstance(com.example.Account_opening_workflowProcess process, Account_opening_workflowModel value, org.kie.api.runtime.process.ProcessRuntime processRuntime) {
        super(process, value, processRuntime);
    }

    public Account_opening_workflowProcessInstance(com.example.Account_opening_workflowProcess process, Account_opening_workflowModel value, java.lang.String businessKey, org.kie.api.runtime.process.ProcessRuntime processRuntime) {
        super(process, value, businessKey, processRuntime);
    }

    public Account_opening_workflowProcessInstance(com.example.Account_opening_workflowProcess process, Account_opening_workflowModel value, org.kie.api.runtime.process.ProcessRuntime processRuntime, org.kie.api.runtime.process.WorkflowProcessInstance wpi) {
        super(process, value, processRuntime, wpi);
    }

    public Account_opening_workflowProcessInstance(com.example.Account_opening_workflowProcess process, Account_opening_workflowModel value, org.kie.api.runtime.process.WorkflowProcessInstance wpi) {
        super(process, value, wpi);
    }

    public Account_opening_workflowProcessInstance(com.example.Account_opening_workflowProcess process, Account_opening_workflowModel value, java.lang.String businessKey, org.kie.api.runtime.process.ProcessRuntime processRuntime, org.kie.kogito.correlation.CompositeCorrelation correlation) {
        super(process, value, businessKey, processRuntime, correlation);
    }

    protected java.util.Map<String, Object> bind(Account_opening_workflowModel variables) {
        if (null != variables)
            return variables.toMap();
        else
            return new java.util.HashMap();
    }

    protected void unbind(Account_opening_workflowModel variables, java.util.Map<String, Object> vmap) {
        variables.fromMap(this.id(), vmap);
    }
}
