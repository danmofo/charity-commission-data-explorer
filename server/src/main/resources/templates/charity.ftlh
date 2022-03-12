<#if charity??>
    <h1>${charity.name}</h1>


    <div id="charity-income-chart" data-chart-data="${charityChartJson?string}"></div>


    <script src="https://cdn.jsdelivr.net/npm/apexcharts"></script>
    <script>
        var SI_SYMBOL = ["", "k", "M", "B", "T", "P", "E"];

        function abbreviateNumber(number){

            // what tier? (determines SI symbol)
            var tier = Math.log10(Math.abs(number)) / 3 | 0;

            // if zero, we don't need a suffix
            if(tier == 0) return number;

            // get suffix and determine scale
            var suffix = SI_SYMBOL[tier];
            var scale = Math.pow(10, tier * 3);

            // scale the number
            var scaled = number / scale;

            // format number and add suffix
            return scaled + suffix;
        }

        var chartEl = document.querySelector('#charity-income-chart');
        var chartData = JSON.parse(chartEl.dataset.chartData);
        var options = {
            series: [
                {
                    name: "Total gross income",
                    data: chartData.incomeDataPoints
                },
                {
                    name: "Total gross expenditure",
                    data: chartData.expenditureDataPoints 
                }
            ],
            yaxis: {
                labels: {
                    formatter: value => {
                        return abbreviateNumber(value);
                    }
                }
            },
            chart: {
              height: 350,
              type: 'line',
              zoom: {
                enabled: false
              }
            },
            colors: ["#247BA0", "#FF1654"],
            dataLabels: {
              enabled: false
            },
            stroke: {
              curve: 'smooth'
            },
            title: {
              text: 'Income and expenditure',
              align: 'left'
            },
            grid: {
              row: {
                colors: ['#f3f3f3', 'transparent'], // takes an array which will be repeated on columns
                opacity: 0.5
              },
            },
            xaxis: {
              categories: chartData.years,
            }
        };

        var chart = new ApexCharts(document.querySelector("#charity-income-chart"), options);
        chart.render();
    </script>
</#if>