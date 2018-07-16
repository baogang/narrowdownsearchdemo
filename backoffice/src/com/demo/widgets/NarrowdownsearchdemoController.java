/*
 * [y] hybris Platform
 *
 * Copyright (c) 2018 SAP SE or an SAP affiliate company.  All rights reserved.
 *
 * This software is the confidential and proprietary information of SAP
 * ("Confidential Information"). You shall not disclose such Confidential
 * Information and shall use it only in accordance with the terms of the
 * license agreement you entered into with SAP.
 */
package com.demo.widgets;

import org.zkoss.zk.ui.Component;
import org.zkoss.zk.ui.select.annotation.WireVariable;
import org.zkoss.zul.Label;

import com.hybris.cockpitng.util.DefaultWidgetController;

import com.demo.services.NarrowdownsearchdemoService;


public class NarrowdownsearchdemoController extends DefaultWidgetController
{
	private static final long serialVersionUID = 1L;
	private Label label;

	@WireVariable
	private transient NarrowdownsearchdemoService narrowdownsearchdemoService;

	@Override
	public void initialize(final Component comp)
	{
		super.initialize(comp);
		label.setValue(narrowdownsearchdemoService.getHello() + " NarrowdownsearchdemoController");
	}
}
