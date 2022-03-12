<h1>Top charities by income</h1>

<ul>
	<#list charities as charity>
		<li><a href="/charities/${charity.organisationNumber?c}">${charity.name}</a> - ${charity.getLatestAnnualReturnPartA().totalGrossIncome?string.currency}</li>
	</#list>
</ul>