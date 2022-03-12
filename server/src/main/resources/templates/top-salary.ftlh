<h1>Top charities by salary</h1>

<table>
	<tr>
		<th style="width: 500px;">Charity name</th>
		<th>Salary min</th>
		<th>Salary max</th>
	</tr>
	<#list charities as charity>
		<tr>
			<td>
				<a href="/charities/${charity.organisationNumber?c}">${charity.name}</a>
			</td>
			<td style="text-align: right;">
				${charity.getLatestAnnualReturnPartA().salaryRangeStart?string.currency}
			</td>
			<td style="text-align: right;">
				${charity.getLatestAnnualReturnPartA().salaryRangeEnd?string.currency}
			</td>
		</tr>
	</#list>
</table>