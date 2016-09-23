package br.com.fiap.bean;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

import org.primefaces.model.chart.AxisType;
import org.primefaces.model.chart.CategoryAxis;
import org.primefaces.model.chart.LineChartModel;
import org.primefaces.model.chart.LineChartSeries;
import org.primefaces.model.chart.PieChartModel;



@ManagedBean
@RequestScoped
public class GraficoBean {

	//Valores para o grafico de pizza
	private PieChartModel graficoPizza;
	
	private LineChartModel graficoLinha;
	
	@PostConstruct
	private void init(){
		//Inicializar os valores dos gr�ficos
		graficoPizza = new PieChartModel();
		
		graficoPizza.set("Russomano", 5000);
		graficoPizza.set("Doria", 50000);
		graficoPizza.set("Haddad", 50000);
		graficoPizza.set("Marta", 5000);
		graficoPizza.set("Erundina", 1000);
		
		//Posi��o da legenda do gr�fico
		graficoPizza.setLegendPosition("e");
		graficoPizza.setShowDataLabels(true);
		
		//Inicializar os valores gr�fico de linha
		graficoLinha = new LineChartModel();
		graficoLinha.setTitle("Elei��es S�o Paulo - 2016");
		graficoLinha.getAxes().put(AxisType.X, new CategoryAxis("Semana"));
		graficoLinha.setLegendPosition("e");
		
		graficoLinha.setAnimate(true);
		graficoLinha.setMouseoverHighlight(true);
		
		//Valores do russomano
		LineChartSeries russo = new LineChartSeries();
		russo.setLabel("Russomano - PSC");
		russo.set("Semana 1", 5000);
		russo.set("Semana 2", 6000);
		russo.set("Semana 3", 1000);
		
		//Valores do D�ria
		LineChartSeries doria = new LineChartSeries();
		doria.setLabel("D�ria - PSDB");
		doria.set("Semana 1", 1000);
		doria.set("Semana 2", 2000);
		doria.set("Semana 3", 6000);
		
		//Adiciona as s�ries (linhas) no gr�fico
		graficoLinha.addSeries(russo);
		graficoLinha.addSeries(doria);
	}

	public PieChartModel getGraficoPizza() {
		return graficoPizza;
	}

	public void setGraficoPizza(PieChartModel graficoPizza) {
		this.graficoPizza = graficoPizza;
	}

	public LineChartModel getGraficoLinha() {
		return graficoLinha;
	}

	public void setGraficoLinha(LineChartModel graficoLinha) {
		this.graficoLinha = graficoLinha;
	}
	
}





