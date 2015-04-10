/*
 * $Id$
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
 */

package org.apache.action2.legacy;

import com.opensymphony.xwork.*;
import com.opensymphony.xwork.config.entities.ActionConfig;
import com.opensymphony.xwork.config.entities.ResultConfig;
import com.opensymphony.xwork.config.entities.ExceptionMappingConfig;
import org.apache.struts.action.*;
import org.apache.struts.config.*;

import java.util.Iterator;
import java.util.Arrays;


/**
 *  Provides conversion methods between the Struts Action 1.x and XWork
 *  classes.
 */
public class StrutsFactory {
    private static StrutsFactory FACTORY = new StrutsFactory();

    protected StrutsFactory() {
    }

    public static void setStrutsFactory(StrutsFactory factory) {
        FACTORY = factory;
    }

    public static StrutsFactory getStrutsFactory() {
        return FACTORY;
    }

    /**
     * Create a Struts 1.x ModuleConfig based on an XWork package configuration.
     * 
     * @param packageName the name of the XWork package configuration to wrap.  This becomes the module prefix for the
     *     newly-created ModuleConfig.
     * @return a wrapper Struts 1.x ModuleConfig.
     */
    public ModuleConfig createModuleConfig(String packageName) {
        assert packageName != null;
        return new WrapperModuleConfig(packageName);
    }

    /**
     * Create a Struts 1.x ActionMapping from an XWork ActionConfig.
     * 
     * @param cfg the XWork ActionConfig.
     * @return a wrapper Struts 1.x ActionMapping.
     */
    public ActionMapping createActionMapping(ActionConfig cfg) {
        assert cfg != null;
        return new WrapperActionMapping(cfg);
    }

    /**
     * Create a Struts 1.x ActionMapping from an XWork ActionConfig.  This version provides an existing action path
     * and ModuleConfig.  Package-protected for now; may not need to be exposed publicly.
     * 
     * @param cfg the XWork ActionConfig.
     * @param actionPath the Struts 1.x-style action path ('/' + action-name).
     * @param moduleConfig the Struts 1.x ModuleConfig that contains the ActionMapping.
     * @return a wrapper Struts 1.x ActionMapping.
     */
    ActionMapping createActionMapping(ActionConfig cfg, String actionPath, ModuleConfig moduleConfig) {
        assert cfg != null;
        assert moduleConfig != null;
        return new WrapperActionMapping(cfg, actionPath, moduleConfig);
    }

    /**
     * Create a Struts 1.x ActionForward from an XWork ResultConfig.
     * 
     * @param cfg the XWork ResultConfig.
     * @return a wrapper Struts 1.x ActionMapping.
     */
    public ActionForward createActionForward(ResultConfig cfg) {
        assert cfg != null;
        return new WrapperActionForward(cfg);
    }

    /**
     * Create a Struts 1.x ExceptionConfig from an XWork ExceptionMappingConfig.
     * 
     * @param cfg the XWork ExceptionMappingConfig.
     * @return a wrapper Struts 1.x ExceptionConfig.
     */
    public ExceptionConfig createExceptionConfig(ExceptionMappingConfig cfg) {
        assert cfg != null;
        return new WrapperExceptionConfig(cfg);
    }

    public void convertErrors(ActionErrors errors, Object action) {
        ValidationAware vaction = null;
        TextProvider text = null;

        if (action instanceof ValidationAware) {
            vaction = (ValidationAware)action;
        }
        if (action instanceof TextProvider) {
            text = (TextProvider)action;
        }

        ActionMessage error = null;
        String field = null;
        String msg = null;
        Object[] values = null;
        for (Iterator i = errors.properties(); i.hasNext(); ) {
            field = (String) i.next();
            for (Iterator it = errors.get(field); it.hasNext(); ) {
                error = (ActionMessage) it.next();
                msg = error.getKey();
                if (error.isResource() && text != null) {
                    values = error.getValues();
                    if (values != null) {
                        msg = text.getText(error.getKey(), Arrays.asList(values));
                    } else {
                        msg = text.getText(error.getKey());
                    }
                }
                if (vaction != null) {
                    if (field == errors.GLOBAL_MESSAGE) {
                        vaction.addActionError(msg);
                    } else {
                        vaction.addFieldError(field, msg);
                    }
                } else {
                    // should do something here
                }
            }
        }
    }
}
