package com.duoc;

import com.duoc.utils.ExcelReportGenerator; // Importar la clase generadora
import org.junit.platform.suite.api.ConfigurationParameter;
import org.junit.platform.suite.api.IncludeEngines;
import org.junit.platform.suite.api.SelectClasspathResource;
import org.junit.platform.suite.api.Suite;
import org.junit.runner.JUnitCore;
import org.junit.runner.Result;

import static io.cucumber.junit.platform.engine.Constants.*;

// Necesitas agregar hooks para ejecutar tareas después de los tests en JUnit 5/Cucumber
// Usaremos @Suite y un método main auxiliar para el post-procesamiento.

@Suite
@IncludeEngines("cucumber")
@SelectClasspathResource("features")
@ConfigurationParameter(key=GLUE_PROPERTY_NAME, value="com.duoc.steps")
@ConfigurationParameter(key=PLUGIN_PROPERTY_NAME, value="pretty, summary, json:target/cucumber-reports/cucumber.json")
public class RunCucumberTest {

    // Método auxiliar para generar el reporte después de la ejecución normal de Maven
    // Maven lo llama automáticamente después de que el Surefire plugin ejecuta esta clase.
    public static void main(String[] args) {
        // Ejecutar la suite de pruebas (esto ya lo maneja Maven, pero se incluye por si se ejecuta manualmente)
        Result result = JUnitCore.runClasses(RunCucumberTest.class);

        // 🚨 Generar el reporte CSV/Excel después de que las pruebas terminaron
        ExcelReportGenerator.generateExcelReport();

        // Opcional: Salir con el código de estado de fallo si alguna prueba falló
        if (!result.wasSuccessful()) {
            System.exit(1);
        }
    }
}