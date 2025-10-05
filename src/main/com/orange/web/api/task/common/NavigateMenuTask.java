package com.orange.web.api.task.common;

import com.orange.web.api.ui.MenuOptionsPage;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.targets.Target;

import java.util.Map;

import static net.serenitybdd.screenplay.Tasks.instrumented;

public class NavigateMenuTask implements Task {

    private final String menuOption;

    public NavigateMenuTask(String menuOption) {
        this.menuOption = menuOption;
    }

    private static final Map<String, Target> MENU_OPTIONS = Map.of(
            "PIM", MenuOptionsPage.OPT_PIM,
            "Dashboard", MenuOptionsPage.OPT_DASHBOARD,
            "Directory", MenuOptionsPage.OPT_DIRECTORY
    );

    @Override
    public <T extends Actor> void performAs(T actor) {
        Target menuTarget = MENU_OPTIONS.get(menuOption);

        if (menuTarget == null) {
            throw new IllegalArgumentException("Opción de menú no esta configurada o no existe: " + menuOption);
        }

        actor.attemptsTo(
                Click.on(menuTarget).afterWaitingUntilEnabled()
        );
    }

    public static NavigateMenuTask to(String menuOption) {
        return instrumented(NavigateMenuTask.class, menuOption);
    }


}
