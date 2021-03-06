/*
 * Licensed to the Apache Software Foundation (ASF) under one
 * or more contributor license agreements.  See the NOTICE file
 * distributed with this work for additional information
 * regarding copyright ownership.  The ASF licenses this file
 * to you under the Apache License, Version 2.0 (the
 * "License"); you may not use this file except in compliance
 * with the License.  You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing,
 * software distributed under the License is distributed on an
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
 * KIND, either express or implied.  See the License for the
 * specific language governing permissions and limitations
 * under the License.
 */

package org.apache.usergrid.corepersistence.index;


import org.apache.usergrid.corepersistence.asyncevents.AsyncEventQueueType;
import org.apache.usergrid.corepersistence.rx.impl.EdgeScope;
import org.apache.usergrid.persistence.core.scope.ApplicationScope;
import org.apache.usergrid.persistence.model.entity.Id;
import java.util.List;


/**
 * Callback to perform an index operation based on an scope during bulk re-index operations
 */
public interface ReIndexAction {

    /**
     * Index this entity with the specified scope
     * @param applicationScope
     * @param id
     */
    void index( final ApplicationScope applicationScope, final Id id, final long updatedSince );

    /**
     * Index a batch list of entities.  Goes to the utility queue.
     * @param edges
     * @param updatedSince
     * @param queueType
     */
    void indexBatch(final List<EdgeScope> edges, final long updatedSince, AsyncEventQueueType queueType);
}
