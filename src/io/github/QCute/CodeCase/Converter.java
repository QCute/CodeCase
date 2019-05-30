package io.github.QCute.CodeCase;

class Converter {
    static String transform(String text){

        if (text.contains(" ")) {
            // space case
            return spaceCaseToKebabCase(text);
        } else if (text.contains("-")) {
            // kebab-case
            return kebabCaseToSnakeCase(text);
        } else if (text.contains("_")) {
            // snake_case
            return snakeCaseToPascalCase(text);
        } else if (text.substring(0, 1).toUpperCase().equals(text.substring(0, 1)) && !text.toUpperCase().equals(text)) {
            // PascalCase
            return pascalCaseToCamelCase(text);
        } else if (text.toUpperCase().equals(text)) {
            // UPPERCASE
            return upperCaseToPascalCase(text);
        } else if (text.toLowerCase().equals(text)) {
            // lowercase
            return lowerCaseToPascalCase(text);
        } else {
            // camelCase
            return camelCaseToSpaceCase(text);
        }
    }
    // space case, kebab-case, snake_case, PascalCase, Pascal, camelCase

    private static String spaceCaseToKebabCase(String in) {
        return in.replace(" ", "-");
    }

    private static String kebabCaseToSnakeCase(String in) {
        return in.replace("-", "_");
    }

    private static String snakeCaseToPascalCase(String in) {
        StringBuilder result = new StringBuilder();
        String[] tokens = in.split("_");
        for (String token : tokens) {
            if (token.length() >= 1) {
                result.append(token.substring(0, 1).toUpperCase()).append(token.substring(1).toLowerCase());
            }
        }
        return result.toString();
    }

    private static String pascalCaseToCamelCase(String in) {
        StringBuilder result = new StringBuilder();
        if (in.length() >= 1) {
            result.append(in.substring(0, 1).toLowerCase()).append(in.substring(1));
        }
        return result.toString();
    }

    private static String lowerCaseToPascalCase(String in) {
        StringBuilder result = new StringBuilder();
        if (in.length() >= 1) {
            result.append(in.substring(0, 1).toUpperCase()).append(in.substring(1));
        }
        return result.toString();
    }

    private static String upperCaseToPascalCase(String in) {
        StringBuilder result = new StringBuilder();
        if (in.length() >= 1) {
            result.append(in.charAt(0)).append(in.substring(1).toLowerCase());
        }
        return result.toString();
    }

    private static String camelCaseToSpaceCase(String in) {
        StringBuilder result = new StringBuilder("" + Character.toLowerCase(in.charAt(0)));
        for (int i = 1; i < in.length(); i++) {
            char c = in.charAt(i);
            if (Character.isUpperCase(c)) {
                result.append(" ").append(Character.toLowerCase(c));
            } else {
                result.append(c);
            }
        }
        return result.toString();
    }

}
