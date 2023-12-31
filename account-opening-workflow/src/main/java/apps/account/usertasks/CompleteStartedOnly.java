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
package apps.account;

import java.util.Arrays;
import java.util.List;

import org.jbpm.process.instance.impl.workitem.Complete;
import org.kie.kogito.process.workitem.LifeCyclePhase;

/**
 * Extension to Complete life cycle phase that applies to any human task.
 * It will set the status to "Completed"
 * 
 * This phase will only allow to complete tasks that are in started phase.
 *
 * It can transition from
 * <ul>
 * <li>Start</li>
 * </ul>
 * 
 * This is a terminating (final) phase.
 */
public class CompleteStartedOnly extends Complete {

    private List<String> allowedTransitions = Arrays.asList(Start.ID);

    @Override
    public boolean canTransition(LifeCyclePhase phase) {
        return allowedTransitions.contains(phase.id());
    }

}
