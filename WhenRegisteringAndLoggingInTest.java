package starter.duckduckgo;

import net.serenitybdd.junit5.SerenityJUnit5Extension;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import static org.assertj.core.api.Assertions.assertThat;

@ExtendWith(SerenityJUnit5Extension.class)
public class WhenRegisteringAndLoggingInTest {

    FormActions formActions = new FormActions();
    NavigateActions navigate = new NavigateActions();

    @Test
    public void userShouldBeAbleToRegisterAndLogin() {
        navigate.toTheHomePage();

        formActions.registerUser(
                "sebas",
                "castaño",
                "sebasd@gmail.com",
                "2001-12-28",
                "quindio",
                "armenia",
                "masculino",
                "Ingeniería"
        );

        boolean registroExitoso = formActions.pageContainsTextVisible("Registro agregado exitosamente.");

        if (!registroExitoso) {
            System.out.println("El texto esperado no apareció en la página.");
        }

        assertThat(registroExitoso)
                .as("El mensaje de confirmación no apareció en la página")
                .isTrue();
    }
}
