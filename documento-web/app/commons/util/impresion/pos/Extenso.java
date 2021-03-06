package commons.util.impresion.pos;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Iterator;

public class Extenso {
	private ArrayList nro;
	private BigInteger num;
	private String[][] Qualificadores;
	private String[][] Numeros;

	public Extenso() {
		this.Qualificadores = new String[][]{{"centavo", "centavos"}, {"", ""}, {"mil", "mil"}, {"milhao", "milhaes"},
				{"bilhao", "bilhaes"}, {"trilhao", "trilhaes"}, {"quatrilhao", "quatrilhaes"},
				{"quintilhao", "quintilhaes"}, {"sextilhao", "sextilhaes"}, {"septilhao", "septilhaes"}};

		this.Numeros = new String[][]{
				{"zero", "um", "dois", "tres", "quatro", "cinco", "seis", "sete", "oito", "nove", "dez", "onze", "doze",
						"treze", "quatorze", "quinze", "desesseis", "desessete", "dezoito", "desenove"},
				{"vinte", "trinta", "quarenta", "cinquenta", "sessenta", "setenta", "oitenta", "noventa"},
				{"cem", "cento", "duzentos", "trezentos", "quatrocentos", "quinhentos", "seiscentos", "setecentos",
						"oitocentos", "novecentos"}};

		this.nro = new ArrayList();
	}

	public Extenso(BigDecimal dec) {
		setNumber(dec);
	}

	public Extenso(double dec) {
		setNumber(dec);
	}

	public void setNumber(BigDecimal dec) {
		this.num = dec.setScale(2, 4).multiply(BigDecimal.valueOf(100L)).toBigInteger();

		this.nro.clear();
		if (this.num.equals(BigInteger.ZERO)) {
			this.nro.add(new Integer(0));

			this.nro.add(new Integer(0));
		} else {
			addRemainder(100);

			while (!(this.num.equals(BigInteger.ZERO)))
				addRemainder(1000);
		}
	}

	public void setNumber(double dec) {
		setNumber(new BigDecimal(dec));
	}

	public void show() {
		Iterator valores = this.nro.iterator();

		while (valores.hasNext()) {
			System.out.println(((Integer) valores.next()).intValue());
		}
		System.out.println(toString());
	}

	public String toString() {
		StringBuffer buf = new StringBuffer();

		int numero = ((Integer) this.nro.get(0)).intValue();

		for (int ct = this.nro.size() - 1; ct > 0; --ct) {
			if ((buf.length() > 0) && (!(ehGrupoZero(ct)))) {
				buf.append(" e ");
			}
			buf.append(numToString(((Integer) this.nro.get(ct)).intValue(), ct));
		}
		if (buf.length() > 0) {
			if (ehUnicoGrupo())
				buf.append(" de ");
			while (buf.toString().endsWith(" "))
				buf.setLength(buf.length() - 1);
			if (ehPrimeiroGrupoUm())
				buf.insert(0, "h");
			if ((this.nro.size() == 2) && (((Integer) this.nro.get(1)).intValue() == 1))
				buf.append(" real");
			else {
				buf.append(" reais");
			}
			if (((Integer) this.nro.get(0)).intValue() != 0) {
				buf.append(" e ");
			}
		}
		if (((Integer) this.nro.get(0)).intValue() != 0) {
			buf.append(numToString(((Integer) this.nro.get(0)).intValue(), 0));
		}
		return buf.toString();
	}

	private boolean ehPrimeiroGrupoUm() {
		return (((Integer) this.nro.get(this.nro.size() - 1)).intValue() == 1);
	}

	private void addRemainder(int divisor) {
		BigInteger[] newNum = this.num.divideAndRemainder(BigInteger.valueOf(divisor));

		this.nro.add(new Integer(newNum[1].intValue()));

		this.num = newNum[0];
	}

	private boolean temMaisGrupos(int ps) {
		for (; ps > 0; --ps) {
			if (((Integer) this.nro.get(ps)).intValue() != 0) {
				return true;
			}
		}

		return false;
	}

	private boolean ehUltimoGrupo(int ps) {
		return ((ps > 0) && (((Integer) this.nro.get(ps)).intValue() != 0) && (!(temMaisGrupos(ps - 1))));
	}

	private boolean ehUnicoGrupo() {
		if (this.nro.size() <= 3)
			return false;
		if ((!(ehGrupoZero(1))) && (!(ehGrupoZero(2))))
			return false;
		boolean hasOne = false;
		for (int i = 3; i < this.nro.size(); ++i) {
			if (((Integer) this.nro.get(i)).intValue() != 0) {
				if (hasOne)
					return false;
				hasOne = true;
			}
		}
		return true;
	}

	boolean ehGrupoZero(int ps) {
		if ((ps <= 0) || (ps >= this.nro.size()))
			return true;
		return (((Integer) this.nro.get(ps)).intValue() == 0);
	}

	private String numToString(int numero, int escala) {
		int unidade = numero % 10;
		int dezena = numero % 100;
		int centena = numero / 100;
		StringBuffer buf = new StringBuffer();

		if (numero != 0) {
			if (centena != 0) {
				if ((dezena == 0) && (centena == 1)) {
					buf.append(this.Numeros[2][0]);
				} else {
					buf.append(this.Numeros[2][centena]);
				}
			}

			if ((buf.length() > 0) && (dezena != 0)) {
				buf.append(" e ");
			}
			if (dezena > 19) {
				dezena /= 10;
				buf.append(this.Numeros[1][(dezena - 2)]);
				if (unidade != 0) {
					buf.append(" e ");
					buf.append(this.Numeros[0][unidade]);
				}
			} else if ((centena == 0) || (dezena != 0)) {
				buf.append(this.Numeros[0][dezena]);
			}

			buf.append(" ");
			if (numero == 1) {
				buf.append(this.Qualificadores[escala][0]);
			} else {
				buf.append(this.Qualificadores[escala][1]);
			}
		}

		return buf.toString();
	}

	public static void main(String[] args) {
		if (args.length == 0) {
			System.out.println("Sintax : ...Extenso <numero>");
			return;
		}
		String num = args[0].replace(',', '.');
		System.out.println(num);
		Extenso teste = new Extenso(new BigDecimal(num));
		System.out.println("Numero  : " + new DecimalFormat().format(Double.valueOf(num)));
		System.out.println("Extenso : " + teste.toString());
	}
}