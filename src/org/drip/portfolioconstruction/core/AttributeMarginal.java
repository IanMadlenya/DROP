
package org.drip.portfolioconstruction.core;

/*
 * -*- mode: java; tab-width: 4; indent-tabs-mode: nil; c-basic-offset: 4 -*-
 */

/*!
 * Copyright (C) 2017 Lakshmi Krishnamurthy
 * 
 *  This file is part of DRIP, a free-software/open-source library for buy/side financial/trading model
 *  	libraries targeting analysts and developers
 *  	https://lakshmidrip.github.io/DRIP/
 *  
 *  DRIP is composed of four main libraries:
 *  
 *  - DRIP Fixed Income - https://lakshmidrip.github.io/DRIP-Fixed-Income/
 *  - DRIP Asset Allocation - https://lakshmidrip.github.io/DRIP-Asset-Allocation/
 *  - DRIP Numerical Optimizer - https://lakshmidrip.github.io/DRIP-Numerical-Optimizer/
 *  - DRIP Statistical Learning - https://lakshmidrip.github.io/DRIP-Statistical-Learning/
 * 
 *  - DRIP Fixed Income: Library for Instrument/Trading Conventions, Treasury Futures/Options,
 *  	Funding/Forward/Overnight Curves, Multi-Curve Construction/Valuation, Collateral Valuation and XVA
 *  	Metric Generation, Calibration and Hedge Attributions, Statistical Curve Construction, Bond RV
 *  	Metrics, Stochastic Evolution and Option Pricing, Interest Rate Dynamics and Option Pricing, LMM
 *  	Extensions/Calibrations/Greeks, Algorithmic Differentiation, and Asset Backed Models and Analytics.
 * 
 *  - DRIP Asset Allocation: Library for model libraries for MPT framework, Black Litterman Strategy
 *  	Incorporator, Holdings Constraint, and Transaction Costs.
 * 
 *  - DRIP Numerical Optimizer: Library for Numerical Optimization and Spline Functionality.
 * 
 *  - DRIP Statistical Learning: Library for Statistical Evaluation and Machine Learning.
 * 
 *  Licensed under the Apache License, Version 2.0 (the "License");
 *   	you may not use this file except in compliance with the License.
 *   
 *  You may obtain a copy of the License at
 *  	http://www.apache.org/licenses/LICENSE-2.0
 *  
 *  Unless required by applicable law or agreed to in writing, software
 *  	distributed under the License is distributed on an "AS IS" BASIS,
 *  	WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *  
 *  See the License for the specific language governing permissions and
 *  	limitations under the License.
 */

/**
 * AttributeMarginal contains the Marginal Attributes for the specified Set of Assets.
 *
 * @author Lakshmi Krishnamurthy
 */

public class AttributeMarginal extends org.drip.portfolioconstruction.core.Block {
	private org.drip.analytics.support.CaseInsensitiveHashMap<java.lang.Double> _mapAttribute = new
		org.drip.analytics.support.CaseInsensitiveHashMap<java.lang.Double>();

	/**
	 * AttributeMarginal Constructor
	 * 
	 * @param strName The Name
	 * @param strID The ID
	 * @param strDescription The Description
	 * 
	 * @throws java.lang.Exception Thrown if the Inputs are Invalid
	 */

	public AttributeMarginal (
		final java.lang.String strName,
		final java.lang.String strID,
		final java.lang.String strDescription)
		throws java.lang.Exception
	{
		super (strName, strID, strDescription);
	}

	/**
	 * Add an Asset and its Attribute
	 * 
	 * @param strAssetID The Asset ID
	 * @param dblAttribute The Attribute
	 * 
	 * @return TRUE => The Asset's Attribute successfully added.
	 */

	public boolean add (
		final java.lang.String strAssetID,
		final double dblAttribute)
	{
		if (null == strAssetID || strAssetID.isEmpty() || !org.drip.quant.common.NumberUtil.IsValid
			(dblAttribute))
			return false;

		_mapAttribute.put (strAssetID, dblAttribute);

		return true;
	}

	/**
	 * Retrieve the Asset's Attribute
	 * 
	 * @param strAssetID The Asset ID
	 * 
	 * @return The Asset's Attribute
	 * 
	 * @throws Thrown if the Inputs are Invalid
	 */

	public double attribute (
		final java.lang.String strAssetID)
		throws java.lang.Exception
	{
		if (null == strAssetID || strAssetID.isEmpty() || !_mapAttribute.containsKey (strAssetID))
			throw new java.lang.Exception ("AttributeMarginal::attribute => Invalid Inputs");

		return _mapAttribute.get (strAssetID);
	}

	/**
	 * Retrieve the Map of Asset Attributes
	 * 
	 * @return Map of the Asset Attributes
	 */

	public java.util.Map<java.lang.String, java.lang.Double> attribute()
	{
		return _mapAttribute;
	}
}