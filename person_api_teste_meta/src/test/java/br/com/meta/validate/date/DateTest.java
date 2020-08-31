package br.com.meta.validate.date;

import java.text.ParseException;
import java.util.Date;

import org.junit.Assert;
import org.junit.Test;

public class DateTest {

		@Test
		public void testeOK() throws ParseException {
			String dataString = "31/08/2020";
			Date date = ConvertDate.parse(dataString, ConvertDate.DateFormat.BR_FORMAT);
			String dataReconvertida = ConvertDate.parse(date, ConvertDate.DateFormat.BR_FORMAT);
			Assert.assertEquals(dataString, dataReconvertida);
		}

		@Test(expected = ParseException.class)
		public void testeDataNula() throws ParseException {
			String dataString = null;
			ConvertDate.parse(dataString, ConvertDate.DateFormat.BR_FORMAT);
		}

		@Test(expected = ParseException.class)
		public void testeFormatoNulo() throws ParseException {
			String dataString = "31/08/2020";
			ConvertDate.parse(dataString, null);
		}

		@Test
		public void testeDataFormatoDiferentes() throws ParseException {
			String dataString = "231/08/2020";
			Date date = ConvertDate.parse(dataString, ConvertDate.DateFormat.USA_FORMAT);
			String dataReconvertida = ConvertDate.parse(date, ConvertDate.DateFormat.BR_FORMAT);
			Assert.assertNotEquals(dataString, dataReconvertida);
		}

	}

