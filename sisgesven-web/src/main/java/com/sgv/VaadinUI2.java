package com.sgv;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;

import com.sgv.core.dao.domain.Company;
import com.sgv.core.service.CompanyService;
import com.sgv.core.view.CompanyEditor;
import com.vaadin.annotations.Theme;
import com.vaadin.icons.VaadinIcons;
import com.vaadin.server.FontAwesome;
import com.vaadin.server.VaadinRequest;
import com.vaadin.shared.ui.ValueChangeMode;
import com.vaadin.spring.annotation.SpringUI;
import com.vaadin.ui.Button;
import com.vaadin.ui.Grid;
import com.vaadin.ui.HorizontalLayout;
import com.vaadin.ui.TextField;
import com.vaadin.ui.UI;
import com.vaadin.ui.VerticalLayout;

//@SpringUI
//@Theme("valo")
public class VaadinUI2 extends UI {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	//@Autowired
	private CompanyService repo;
	
	private CompanyEditor editor;
	
    private Company company;

    private Grid<Company> grid;    
	final TextField filter;
	private final Button addNewBtn;
	/*
    private Button addNew = new Button(VaadinIcons.PLUS, this::add);
    private Button edit = new Button(VaadinIcons.PENCIL, this::edit);
    private Button delete = new ConfirmButton(VaadinIcons.TRASH,
            "Are you sure you want to delete the entry?", this::remove);
*/
    @Autowired
    public VaadinUI2(CompanyService repo, CompanyEditor editor){
    	this.repo = repo;
    	this.editor = editor;    	
        this.grid = new Grid<>(Company.class);
		this.filter = new TextField();
		this.addNewBtn = new Button("Nueva Compañia", FontAwesome.PLUS);//new Button("Nueva Compañia", VaadinIcons.PLUS);
    }
    
    @Override
    protected void init(VaadinRequest request) {
    	// build layout
		HorizontalLayout actions = new HorizontalLayout(filter, addNewBtn);
		VerticalLayout mainLayout = new VerticalLayout(actions, grid, editor);
		setContent(mainLayout);

		grid.setHeight(300, Unit.PIXELS);
		grid.setColumns("id", "name", "website");

		filter.setPlaceholder("Filtrar por nombre");

		// Hook logic to components

		// Replace listing with filtered content when user changes filter
		filter.setValueChangeMode(ValueChangeMode.LAZY);
		filter.addValueChangeListener(e -> listCompanys(e.getValue()));

		// Connect selected Company to editor or hide if none is selected
		grid.asSingleSelect().addValueChangeListener(e -> {
			editor.editCompany(e.getValue());
		});

		// Instantiate and edit new Company the new button is clicked
		addNewBtn.addClickListener(e -> editor.editCompany(new Company("", "")));

		// Listen changes made by the editor, refresh data from backend
		editor.setChangeHandler(() -> {
			editor.setVisible(false);
			listCompanys(filter.getValue());
		});

		// Initialize listing
		listCompanys(null);
    }

	// tag::listCompanys[]
	void listCompanys(String filterText) {
		if (StringUtils.isEmpty(filterText)) {
			grid.setItems(repo.findAll());
		}
		else {
			grid.setItems(repo.findByFilter(filterText));
		}
	}
	// end::listCompanys[]    
}