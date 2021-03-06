package com.spaeth.appbase.adds.vaadin.component;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import com.spaeth.appbase.adds.vaadin.ComponentWrapperHelper;
import com.vaadin.ui.AbstractComponentContainer;

public abstract class ComponentContainer<ComponentClass extends AbstractComponentContainer> extends DetacheableComponent<ComponentClass> implements
com.spaeth.appbase.component.ComponentContainer {

	private static final long serialVersionUID = 1L;

	private final List<com.spaeth.appbase.component.DetacheableComponent> detacheableComponents = new ArrayList<com.spaeth.appbase.component.DetacheableComponent>();

	@Override
	public void addComponent(final com.spaeth.appbase.component.DetacheableComponent component) {
		component.setParent(this);

		internalAddComponent(component);
	}

	protected void internalAddComponent(final com.spaeth.appbase.component.DetacheableComponent component) {
		DetacheableComponent<?> unwrappedComponent = ComponentWrapperHelper.unwrap(component, DetacheableComponent.class);

		detacheableComponents.add(unwrappedComponent);
	}

	@Override
	public void removeComponent(final com.spaeth.appbase.component.DetacheableComponent component) {
		component.setParent(null);

		internalRemoveComponent(component);
	}

	protected void internalRemoveComponent(final com.spaeth.appbase.component.DetacheableComponent component) {
		DetacheableComponent<?> unwrappedComponent = ComponentWrapperHelper.unwrap(component, DetacheableComponent.class);

		detacheableComponents.remove(unwrappedComponent);
	}

	@Override
	public List<com.spaeth.appbase.component.DetacheableComponent> getComponents() {
		return Collections.unmodifiableList(detacheableComponents);
	}

}
