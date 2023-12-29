package org.kie.kogito.handlers;

import org.kie.kogito.process.workitem.WorkItemExecutionException;

@javax.enterprise.context.ApplicationScoped()
public class ServiceRoute_accountOpen_6_Handler implements org.kie.kogito.internal.process.runtime.KogitoWorkItemHandler {

    apps.account.ServiceRoute service;

    public ServiceRoute_accountOpen_6_Handler() {
        this(new apps.account.ServiceRoute());
    }

    @javax.inject.Inject()
    public ServiceRoute_accountOpen_6_Handler(apps.account.ServiceRoute service) {
        this.service = service;
    }

    public void executeWorkItem(org.kie.kogito.internal.process.runtime.KogitoWorkItem workItem, org.kie.kogito.internal.process.runtime.KogitoWorkItemManager workItemManager) {
        service.accountOpen((java.lang.String) workItem.getParameter("accountnumber"), (java.lang.String) workItem.getParameter("result"));
        workItemManager.completeWorkItem(workItem.getStringId(), java.util.Collections.emptyMap());
    }

    public void abortWorkItem(org.kie.kogito.internal.process.runtime.KogitoWorkItem workItem, org.kie.kogito.internal.process.runtime.KogitoWorkItemManager workItemManager) {
    }

    public String getName() {
        return "apps.account.ServiceRoute_accountOpen_6_Handler";
    }
}
