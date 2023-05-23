package com.blogspot.dastinsandura;

import org.yaml.snakeyaml.DumperOptions;
import org.yaml.snakeyaml.Yaml;

public class Main {
    public static void main(String[] args) {
        System.out.println("This is a showcase of ho library snakeyaml works.");
        printExampleOfYamlCollectionWithoutNestedCollections();
        showExampleOfPrintingYamlCollectionWithNestedCollections();
        printExampleOfYamlCollectionWithoutNestedCollectionsWithDumperOptions();
    }

    /**
     * If the collection has nested collection it will print it in the "block style"
     * See: <a href="https://redocly.com/docs/yaml/maps/#flow-maps">yaml documentation about flow and block style</a>
     */
    private static void showExampleOfPrintingYamlCollectionWithNestedCollections() {
        Yaml y = new Yaml();
        String document = " a: 1\n b: \n  x: 7\n  y: 8\n c: 3\n d: 4\n";
        System.out.println("Source document");
        System.out.println(document);
        System.out.println("Document after formatting by snakeyaml");
        System.out.println(y.dump(y.load(document)));
    }

    /**
     * By default, snakeyaml prints collections in the "flow style"
     * See: <a href="https://redocly.com/docs/yaml/maps/#flow-maps">yaml documentation about flow and block style</a>
     */
    private static void printExampleOfYamlCollectionWithoutNestedCollections() {
        Yaml y = new Yaml();
        String document = " a: 1\n b:\n c: 3\n d: 4\n";
        System.out.println("Source document");
        System.out.println(document);
        System.out.println("Document after formatting by snakeyaml");
        System.out.println(y.dump(y.load(document)));
    }

    /**
     * By default, snakeyaml prints collections in the "flow style"
     * See: <a href="https://redocly.com/docs/yaml/maps/#flow-maps">yaml documentation about flow and block style</a>
     */
    private static void printExampleOfYamlCollectionWithoutNestedCollectionsWithDumperOptions() {
        DumperOptions options = new DumperOptions();
        options.setDefaultFlowStyle(DumperOptions.FlowStyle.BLOCK);
        Yaml y = new Yaml(options);
        String document = " a: 1\n b: \n  x: 7\n  y: 8\n c: 3\n d: 4\n";
        System.out.println("Source document");
        System.out.println(document);
        System.out.println("Document after formatting by snakeyaml");
        System.out.println(y.dump(y.load(document)));
    }
}