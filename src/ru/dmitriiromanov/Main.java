package ru.dmitriiromanov;

public class Main {

    public static void main(String[] args) {
        String string = "Еъёчхф Вхзёюлх, адздёиу ф ждэщхб, црбх еёдюэчъщъгюъв южаижжзчх, ждчъёнъгжзчдв. Ъы зёюивй жёхчгюв бюнс ж ъы вдгивъгзхбсгрв аёхкдв. Зъеъёс вгъ дмъчющгд, мзд гъюэцъьгджзс тздшд аёхкх фчбфъзжф жбъщжзчюъв гъждчъёнъгжзчх мъбдчъмъжадшд югщючющиивх. Ф юэимюб чхни южздёюу ю чгыж юэвъгъгюф, здмгъъ дзёхэюч еджздфггиу юэвъгмючджзс мъбдчъмъжаюк едёдадч. Ю зъв гъ въгъъ, еджбъщдчхбх гъищхмх. Ф еёюнъб а чрчдщи, мзд чюгдя чжъви вдя югзъббъаз, х чдэвдьгд, вды мёъэвъёгдъ жзёъвбъгюъ ад чжъви шхёвдгюмгдви. Гхязю ёънъгюъ вгъ едвдшбх еёдшёхввх югзиюзючгдшд зюех, жеълюхбсгд ждэщхггхф щбф юэимъгюф деёъщъбъггрк жздёдг мъбдчъмъжадя щиню. Въгф вдьгд гхэчхзс дзлдв Вхзёюлр, х ъы, цъэ еёъичъбюмъгюф, вхзъёсу.";
        getText(string);
    }

    static void getText(String str) {
        int shiftCount = 0;
        char[] symbolString = str.toLowerCase().toCharArray();
        char[] decryptedString = new char[symbolString.length];
        for (int k = 0; k < 33; k++) {
            for (int i = 0, j = 0; i < symbolString.length; i++) {
                if (symbolString[i] == ' ' || symbolString[i] == ',' || symbolString[i] == '.') {
                    decryptedString[j] = symbolString[i];
                } else {
                    decryptedString[j] = getSymbol(symbolString[i], shiftCount);
                }
                j++;
            }
            System.out.println(new String(decryptedString));
            shiftCount++;
        }
    }

    static char getSymbol(char symbol, int shift) {
        char newSymbol = 0;
        char[] symbolArr = {'а', 'б', 'в', 'г', 'д', 'е', 'ё', 'ж', 'з', 'и', 'й', 'к', 'л', 'м', 'н',
                'о', 'п', 'р', 'с', 'т', 'у', 'ф', 'х', 'ц', 'ч', 'ш', 'щ', 'ъ', 'ы', 'ь', 'э', 'ю', 'я'};
        for (int i = 0; i < symbolArr.length; i++) {
            if (symbol == symbolArr[i]) {
                if ((symbolArr.length - 1) - i >= shift) {
                    newSymbol = symbolArr[i + shift];
                } else {
                    int count = shift - ((symbolArr.length - 1) - i);
                    newSymbol = symbolArr[count - 1];
                }
            }
        }
        return newSymbol;
    }
}
