/*
 * Licensed to the Apache Software Foundation (ASF) under one or more
 * contributor license agreements.  See the NOTICE file distributed with
 * this work for additional information regarding copyright ownership.
 * The ASF licenses this file to You under the Apache License, Version 2.0
 * (the "License"); you may not use this file except in compliance with
 * the License.  You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.apache.marmotta.platform.backend.virtuoso;

import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;

import org.apache.marmotta.platform.core.logging.BaseLoggingModule;

import ch.qos.logback.classic.Level;

public class VirtuosoLoggingModule extends BaseLoggingModule {

    private static final Collection<String> LOG_PACKAGES = Collections.unmodifiableCollection(Arrays.asList(
                    "org.apache.marmotta.platform.backend.virtuoso",
                    "virtuoso",
                    "openlink.util"
            ));
    
    @Override
    public String getId() {
        return "virtuoso";
    }

    @Override
    public String getName() {
        return "Virtuoso Backend";
    }

    @Override
    public Collection<String> getPackages() {
        return LOG_PACKAGES;
    }

    @Override
    public Level getDefaultLevel() {
        return Level.WARN;
    }

}
