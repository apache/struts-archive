/*
 * Copyright 2004 The Apache Software Foundation.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 * 
 *     http://www.apache.org/licenses/LICENSE-2.0
 * 
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 *
 * $Header:$
 */
package org.apache.action2.legacy;

import com.opensymphony.xwork.config.entities.ExceptionMappingConfig;
import org.apache.struts.config.ExceptionConfig;

/**
 * Wrapper for a Struts 1.x ExceptionConfig based on an XWork ExceptionMappingConfig.  Using a
 * wrapper object allows us to be explicit about what is and isn't implemented.
 */
class WrapperExceptionConfig extends ExceptionConfig {

    private ExceptionMappingConfig delegate;

    public WrapperExceptionConfig(ExceptionMappingConfig delegate) {
        this.delegate = delegate;
        freeze();
    }

    public String getBundle() {
        throw new UnsupportedOperationException("NYI");
    }

    public String getHandler() {
        throw new UnsupportedOperationException("NYI");
    }

    public String getKey() {
        throw new UnsupportedOperationException("NYI");
    }

    public String getPath() {
        throw new UnsupportedOperationException("NYI");
    }

    public String getScope() {
        throw new UnsupportedOperationException("NYI");
    }

    public String getType() {
        return delegate.getExceptionClassName();
    }

    public String toString() {
        return "wrapper -> " + delegate.toString();
    }
}
