package com.duoc.utils;

import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
// Importaciones necesarias para OpenCSV
import com.opencsv.CSVWriter;
import com.opencsv.CSVWriterBuilder;
import com.opencsv.ICSVWriter;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class ExcelReportGenerator {

    private static final String JSON_INPUT_PATH = "target/cucumber-reports/cucumber.json";
    private static final String CSV_OUTPUT_PATH = "target/cucumber-reports/resumen_pruebas.csv";

    public static void main(String[] args) {
        generateExcelReport();
    }

    public static void generateExcelReport() {
        System.out.println("--- Generando reporte resumen para Excel (CSV) ---");

        try {
            // 1. Configurar el escritor CSV usando el Builder
            // Esto es compatible con las versiones nuevas de OpenCSV y evita el error de constructor.
            ICSVWriter writer = new CSVWriterBuilder(new FileWriter(CSV_OUTPUT_PATH))
                    .withSeparator(';')           // Separador de punto y coma para Excel
                    .withQuoteChar('"')           // Carácter de comillas
                    .build();

            // 2. Cabecera del archivo CSV
            String[] header = {"Feature", "Scenario", "Status", "Duration (ms)"};
            writer.writeNext(header);

            // 3. Leer el archivo JSON de Cucumber
            JsonArray cucumberReport = readCucumberJson();

            // 4. Procesar cada elemento del reporte
            List<String[]> dataLines = processReport(cucumberReport);
            writer.writeAll(dataLines);

            // IMPORTANTE: Cerrar el escritor para guardar los cambios
            writer.close();

            System.out.println("✅ Reporte Excel (CSV) generado exitosamente en: " + CSV_OUTPUT_PATH);

        } catch (Exception e) {
            System.err.println("❌ ERROR al generar el reporte Excel: " + e.getMessage());
            e.printStackTrace();
        }
    }

    // ... (El resto de los métodos: readCucumberJson y processReport se mantienen igual)
    // Método para leer el archivo JSON
    private static JsonArray readCucumberJson() throws IOException {
        try (FileReader reader = new FileReader(JSON_INPUT_PATH)) {
            Gson gson = new Gson();
            return gson.fromJson(reader, JsonArray.class);
        }
    }

    // Método para extraer los datos relevantes
    private static List<String[]> processReport(JsonArray report) {
        List<String[]> records = new ArrayList<>();

        for (JsonElement featureElement : report) {
            JsonObject featureObject = featureElement.getAsJsonObject();
            String featureName = featureObject.get("name").getAsString();

            JsonArray elements = featureObject.getAsJsonArray("elements");

            for (JsonElement scenarioElement : elements) {
                JsonObject scenarioObject = scenarioElement.getAsJsonObject();
                String scenarioName = scenarioObject.get("name").getAsString();

                // Asume que la mayoría de los escenarios tienen solo un paso que determina el resultado
                JsonArray steps = scenarioObject.getAsJsonArray("steps");

                String finalStatus = "UNKNOWN";
                long totalDuration = 0; // en nanosegundos

                for (JsonElement stepElement : steps) {
                    JsonObject stepObject = stepElement.getAsJsonObject();
                    if (stepObject.has("result")) {
                        JsonObject result = stepObject.getAsJsonObject("result");
                        finalStatus = result.get("status").getAsString().toUpperCase();

                        if (result.has("duration")) {
                            totalDuration += result.get("duration").getAsLong();
                        }
                    }
                }

                // Convertir nanosegundos a milisegundos
                long durationMs = totalDuration / 1_000_000;

                // Añadir el registro resumido
                records.add(new String[]{
                        featureName,
                        scenarioName,
                        finalStatus,
                        String.valueOf(durationMs)
                });
            }
        }
        return records;
    }
}