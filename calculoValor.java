
public class calculoValor {
	private Acesso source;
	
	int quantidadeHoras,
		quantidadeMinutos;
	
	float valorTotal,
		  valorHora,
		  valorFracao;
	
	public calculoValor(Acesso source) {
		this.source = source;
	}
	
	public float computar() {
		quantidadeHoras = source.horaSaida - source.horaEntrada; 
				
		if (source.horaSaida == source.horaEntrada)
			quantidadeMinutos = source.minutosSaida - source.minutosEntrada;
		else if (source.horaSaida > source.horaEntrada && source.minutosEntrada == source.minutosSaida){
			quantidadeMinutos = 0;
			quantidadeHoras = source.horaSaida - source.horaEntrada;
		}
		else if (source.horaSaida > source.horaEntrada && source.minutosEntrada > source.minutosSaida) 
			quantidadeMinutos = source.minutosSaida - source.minutosEntrada;
		else if (source.horaSaida > source.horaEntrada && source.minutosSaida < source.minutosEntrada){
			quantidadeMinutos = source.minutosSaida + (60 - source.minutosEntrada);
			quantidadeHoras = source.horaSaida - source.horaEntrada - 1;
		}
		else {
			quantidadeHoras = 0;
			quantidadeMinutos = 0;
		}
		
		valorTotal = 0; 
		valorHora = valorTotal + quantidadeHoras * source.VALOR_HORA;
		valorFracao = (float) (valorHora + Math.ceil(quantidadeMinutos / 15.0) * source.VALOR_FRACAO);		
		
		if (quantidadeHoras >=9)
			return source.VALOR_DIARIA;
		else 
			return valorFracao;
	}
}
