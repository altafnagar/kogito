/*
 * Copyright 2020 Red Hat, Inc. and/or its affiliates.
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

import org.kie.kogito.MapInput;
import org.kie.kogito.MapInputId;
import org.kie.kogito.MapOutput;
import java.util.Map;
import java.util.HashMap;
import org.kie.kogito.MappableToModel;
import org.kie.kogito.Model;
import org.kie.kogito.ProcessInput;

@org.kie.kogito.codegen.Generated(value = "kogito-codegen", reference = "account_opening_workflow", name = "Account_opening_workflow", hidden = true)
@ProcessInput(processName = "account_opening_workflow")
public class Account_opening_workflowModelInput implements Model, MapInput, MapInputId, MapOutput, MappableToModel<Account_opening_workflowModel> {

    @org.kie.kogito.codegen.VariableInfo(tags = "")
    @com.fasterxml.jackson.annotation.JsonProperty(value = "result")
    @javax.validation.Valid()
    private java.lang.String result;

    public java.lang.String getResult() {
        return result;
    }

    public void setResult(java.lang.String result) {
        this.result = result;
    }

    @org.kie.kogito.codegen.VariableInfo(tags = "")
    @com.fasterxml.jackson.annotation.JsonProperty(value = "accountnumber")
    @javax.validation.Valid()
    private java.lang.String accountnumber;

    public java.lang.String getAccountnumber() {
        return accountnumber;
    }

    public void setAccountnumber(java.lang.String accountnumber) {
        this.accountnumber = accountnumber;
    }

    @Override()
    public Account_opening_workflowModel toModel() {
        Account_opening_workflowModel result = new Account_opening_workflowModel();
        result.setResult(getResult());
        result.setAccountnumber(getAccountnumber());
        return result;
    }
}
