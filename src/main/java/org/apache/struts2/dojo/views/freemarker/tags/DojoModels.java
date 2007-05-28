package org.apache.struts2.dojo.views.freemarker.tags;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.views.freemarker.tags.AnchorModel;
import org.apache.struts2.views.freemarker.tags.DivModel;
import org.apache.struts2.views.freemarker.tags.SubmitModel;

import com.opensymphony.xwork2.util.ValueStack;

public class DojoModels {
    protected DateTimePickerModel dateTimePicker;
    protected TabbedPanelModel tabbedPanel;
    protected TreeModel treeModel;
    protected TreeNodeModel treenodeModel;
    protected AutocompleterModel autocompleter;
    protected DivModel div;
    protected AnchorModel a;
    protected SubmitModel submit;
    protected BindModel bind;
    protected HeadModel head;
    
    private ValueStack stack;
    private HttpServletRequest req;
    private HttpServletResponse res;
    
    public DojoModels(ValueStack stack, HttpServletRequest req, HttpServletResponse res) {
        this.stack = stack;
        this.req = req;
        this.res = res;
    }
    
    public BindModel getBind() {
        if (bind == null) {
            bind = new BindModel(stack, req, res);
        }

        return bind;
    }
    
    public HeadModel getHead() {
        if (head == null) {
            head = new HeadModel(stack, req, res);
        }

        return head;
    }
    
    public DateTimePickerModel getDatetimepicker() {
        if (dateTimePicker == null) {
            dateTimePicker = new DateTimePickerModel(stack, req, res);
        }

        return dateTimePicker;
    }
    
    public AutocompleterModel getAutocompleter() {
        if (autocompleter == null) {
            autocompleter = new AutocompleterModel(stack, req, res);
        }

        return autocompleter;
    }
    
    public TabbedPanelModel getTabbedpanel() {
        if (tabbedPanel == null) {
            tabbedPanel = new TabbedPanelModel(stack, req, res);
        }

        return tabbedPanel;
    }
    
    public TreeModel getTree() {
        if (treeModel == null) {
            treeModel = new TreeModel(stack,req, res);
        }
        return treeModel;
    }

    public TreeNodeModel getTreenode() {
        if (treenodeModel == null) {
            treenodeModel = new TreeNodeModel(stack, req, res);
        }
        return treenodeModel;
    }
    
    public DivModel getDiv() {
        if (div == null) {
            div = new DivModel(stack, req, res);
        }

        return div;
    }
    
    public AnchorModel getA() {
        if (a == null) {
            a = new AnchorModel(stack, req, res);
        }

        return a;
    }
    
    public SubmitModel getSubmit() {
        if (submit == null) {
            submit = new SubmitModel(stack, req, res);
        }

        return submit;
    }
}
