package com.sgv.core.view;

import org.springframework.beans.factory.annotation.Autowired;

import com.sgv.core.dao.domain.Company;
import com.sgv.core.service.CompanyService;
import com.vaadin.data.Binder;
import com.vaadin.event.ShortcutAction;
import com.vaadin.server.FontAwesome;
import com.vaadin.spring.annotation.SpringComponent;
import com.vaadin.spring.annotation.UIScope;
import com.vaadin.ui.Button;
import com.vaadin.ui.CssLayout;
import com.vaadin.ui.TextField;
import com.vaadin.ui.VerticalLayout;
import com.vaadin.ui.themes.ValoTheme;

/**
 * A simple example to introduce building forms. As your real application is probably much
 * more complicated than this example, you could re-use this form in multiple places. This
 * example component is only used in VaadinUI.
 * <p>
 * In a real world application you'll most likely using a common super class for all your
 * forms - less code, better UX. See e.g. AbstractForm in Viritin
 * (https://vaadin.com/addon/viritin).
 */
@SpringComponent
@UIScope
public class CompanyEditor extends VerticalLayout {

	private final CompanyService service;

	/**
	 * The currently edited customer
	 */
	private Company customer;

	/* Fields to edit properties in Company entity */
	TextField name = new TextField("Nombre");
	TextField website = new TextField("Pagina web");

	/* Action buttons */
	Button save = new Button("Guardar", FontAwesome.SAVE);
	Button update = new Button("Guardar", FontAwesome.SAVE);
	Button cancel = new Button("Cancelar");
	Button delete = new Button("Borrar", FontAwesome.TRASH_O);
	CssLayout actions = new CssLayout(save, update, cancel, delete);

	Binder<Company> binder = new Binder<>(Company.class);

	@Autowired
	public CompanyEditor(CompanyService service) {
		this.service = service;

		addComponents(name, website, actions);

		// bind using naming convention
		binder.bindInstanceFields(this);

		// Configure and style components
		setSpacing(true);
		actions.setStyleName(ValoTheme.LAYOUT_COMPONENT_GROUP);
		save.setStyleName(ValoTheme.BUTTON_PRIMARY);
		save.setClickShortcut(ShortcutAction.KeyCode.ENTER);
		update.setStyleName(ValoTheme.BUTTON_PRIMARY);
		update.setClickShortcut(ShortcutAction.KeyCode.ENTER);		
		

		// wire action buttons to save, delete and reset
		save.addClickListener(e -> service.save(customer));
		update.addClickListener(e -> service.update(customer));
		delete.addClickListener(e -> service.delete(customer));
		cancel.addClickListener(e -> editCompany(customer));
		setVisible(false);
	}

	public interface ChangeHandler {

		void onChange();
	}

	public final void editCompany(Company c) {
		if (c == null) {
			setVisible(false);
			return;
		}
		final boolean persisted = c.getId() != null; //no es nulo TRUE(Existe), es nulo FALSE(No Existe)
		if (persisted) {
			// Find fresh entity for editing
			customer = service.findOne(c.getId());
		}
		else {
			customer = c;
			// A hack to ensure the whole form is visible
			save.focus();
		}
		save.setVisible(!persisted);
		update.setVisible(persisted);
		cancel.setVisible(persisted);

		// Bind customer properties to similarly named fields
		// Could also use annotation or "manual binding" or programmatically
		// moving values from fields to entities before saving
		binder.setBean(customer);

		setVisible(true);

		// A hack to ensure the whole form is visible
		//save.focus();
		// Select all text in firstName field automatically
		name.selectAll();
	}

	public void setChangeHandler(ChangeHandler h) {
		// ChangeHandler is notified when either save or delete
		// is clicked
		save.addClickListener(e -> h.onChange());
		update.addClickListener(e -> h.onChange());
		delete.addClickListener(e -> h.onChange());
	}
}
