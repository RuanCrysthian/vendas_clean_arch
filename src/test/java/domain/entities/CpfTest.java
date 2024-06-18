package domain.entities;

import domain.exception.CpfInvalidException;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class CpfTest {

  @Test
  void deveValidarCpf() {
    String cpfValido = "935.411.347-80";
    Cpf cpf = new Cpf(cpfValido);
    Assertions.assertNotNull(cpf);
    Assertions.assertEquals(cpfValido, cpf.getValue());
  }

  @Test
  void deveValidarCpfComecandoComZero() {
    String cpfValido = "059.561.551-16";
    Cpf cpf = new Cpf(cpfValido);
    Assertions.assertNotNull(cpf);
    Assertions.assertEquals(cpfValido, cpf.getValue());
  }

  @Test
  void deveTentarValidarCpfInvalido() {
    String cpfInvalido = "123.456.789-99";
    Assertions.assertThrows(CpfInvalidException.class, () -> new Cpf(cpfInvalido));
  }

  @Test
  void deveTentarValidarCpfComDigitosIguais() {
    String cpfInvalido = "111.111.111-11";
    Assertions.assertThrows(CpfInvalidException.class, () -> new Cpf(cpfInvalido));
  }

  @Test
  void deveTentarValidarCpfMuitoGrande() {
    String cpfInvalido = "123.456.789-1000";
    Assertions.assertThrows(CpfInvalidException.class, () -> new Cpf(cpfInvalido));
  }

  @Test
  void deveTentarValidarCpfMuitoPequeno() {
    String cpfInvalido = "123.456";
    Assertions.assertThrows(CpfInvalidException.class, () -> new Cpf(cpfInvalido));
  }
}
