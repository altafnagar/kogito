/*
 * Copyright 2019 Red Hat, Inc. and/or its affiliates.
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

import java.util.HashMap;
import java.util.Map;
import org.kie.kogito.MapOutput;
import org.kie.kogito.UserTask;

@UserTask(taskName = "CPUAuthorize", processName = "account_opening_workflow")
public class Account_opening_workflow_1_TaskOutput implements MapOutput {

    @Override
    public Map<String, Object> toMap() {
        Map<String, Object> params = new HashMap<>();
        return params;
    }

    public static Account_opening_workflow_1_TaskOutput fromMap(Map<String, Object> params) {
        com.example.Account_opening_workflow_1_TaskOutput result = new Account_opening_workflow_1_TaskOutput();
        return result;
    }
}
// Task output for user task 'CPU Authorize' in process 'account_opening_workflow'
