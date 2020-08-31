package br.com.meta.validate.cpf;

import org.junit.Assert;
import org.junit.Test;

public class CpfTest {

	private String cpf;
	
	@Test
	public void validCpf() {
		Assert.assertEquals(true,validCpf("03998499989"));
		Assert.assertEquals(true,validCpf("039.984.999-89"));
		Assert.assertEquals(true,validCpf("00098499989"));
		Assert.assertEquals(true,validCpf("000.984.999-89"));
	}
	
	public boolean validCpf(String cpf) {
		if (cpf == null) {
			return false;
		} else {
			String cpfGenerated = "";
			this.cpf = cpf;
			removeCaracter();
			if (checkLengthInvalid(this.cpf))
				return false;
			if (checkEquals(this.cpf))
				return false;
			cpfGenerated = this.cpf.substring(0, 9);
			cpfGenerated = cpfGenerated.concat(calculeCpf(cpfGenerated));
			cpfGenerated = cpfGenerated.concat(calculeCpf(cpfGenerated));

			if (!cpfGenerated.equals(this.cpf))
				return false;
		}
		return true;
	}

	private void removeCaracter() {
		this.cpf = this.cpf.replace("-", "");
		this.cpf = this.cpf.replace(".", "");
	}

	private boolean checkLengthInvalid(String cpf) {
		if (cpf.length() != 11)
			return true;
		return false;
	}

	private boolean checkEquals(String cpf) {
		char primDig = '0';
		char[] charCpf = cpf.toCharArray();
		for (char c : charCpf)
			if (c != primDig)
				return false;
		return true;
	}

	private String calculeCpf(String cpf) {
		int digGerado = 0;
		int mult = cpf.length() + 1;
		char[] charCpf = cpf.toCharArray();
		for (int i = 0; i < cpf.length(); i++)
			digGerado += (charCpf[i] - 48) * mult--;
		if (digGerado % 11 < 2)
			digGerado = 0;
		else
			digGerado = 11 - digGerado % 11;
		return String.valueOf(digGerado);
	}

}
