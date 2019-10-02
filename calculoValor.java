
public class calculoValor {
	private Acesso source;
	
	int quantidadeHoras,
		quantidadeMinutos;
	
	float valorHora,
		  valorFracao;
	
	public calculoValor(Acesso source) {
		this.source = source;
	}
	
	public float computar() {
						
		if (source.horaSaida == source.horaEntrada) {
			quantidadeMinutos = calculoQtdMinutos();
			quantidadeHoras = calculoQtdHoras(); 
		}
		else if (saidaEhMaiorEntrada() && source.minutosEntrada == source.minutosSaida){
			quantidadeMinutos = 0;
			quantidadeHoras = calculoQtdHoras();
		}
		else if (saidaEhMaiorEntrada() &&  entradaEhMaiorSaida()){
			quantidadeMinutos = calculoQtdMinutos() + 60;
			quantidadeHoras = calculoQtdHoras() - 1;
		}
		else {
			quantidadeHoras = 0;
			quantidadeMinutos = 0;
		}
		
		valorHora = quantidadeHoras * source.VALOR_HORA;
		valorFracao = (float) (valorHora + Math.ceil(quantidadeMinutos / 15.0) * source.VALOR_FRACAO);		
		
		if (quantidadeHoras >=9)
			return source.VALOR_DIARIA;
		else 
			return valorFracao;
	}

	private boolean entradaEhMaiorSaida() {
		return source.minutosEntrada > source.minutosSaida;
	}

	private boolean saidaEhMaiorEntrada() {
		return source.horaSaida > source.horaEntrada;
	}

	private int calculoQtdMinutos() {
		return source.minutosSaida - source.minutosEntrada;
	}

	private int calculoQtdHoras() {
		return source.horaSaida - source.horaEntrada;
	}
}
