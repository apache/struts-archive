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

import org.apache.struts.action.ActionForward;
import com.opensymphony.xwork.config.entities.ResultConfig;

/**
 * Wrapper for a Struts 1.x ActionForward based on an XWork ResultConfig.  Using a wrapper object
 * allows us to be explicit about what is and isn't implemented.
 */
class WrapperActionForward extends ActionForward {

    private ResultConfig delegate;
    
    public WrapperActionForward(ResultConfig delegate) {
        super(delegate.getName());
        this.delegate = delegate;
        freeze();
    }

    public String getName() {
        return delegate.getName();
    }

    public String getPath() {
        throw new UnsupportedOperationException("NYI");
    }

    public String getModule() {
        throw new UnsupportedOperationException("NYI");
    }

    public boolean getRedirect() {
        throw new UnsupportedOperationException("NYI");
    }

    public String toString() {
        return "wrapper -> " + delegate.toString();
    }
}
