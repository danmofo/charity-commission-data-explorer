<h1>Top charities by income</h1>

<ul>
	<#list charities as charity>
		<li>${charity.name} - ${charity.getLatestAnnualReturnPartA().totalGrossIncome}</li>
	</#list>
</ul>