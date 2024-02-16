import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class Task {

  public static void inputFio()
      throws FioFormatException, IOException, UnsupportedDataFormat, PhoneNumberException, GenderSelectionException {
    Scanner scanner = new Scanner(System.in);

    // Ввод ФИО
    System.out.println("Введите ваше ФИО через запятую");
    String x = scanner.next();
    String[] fio = x.split(",");
    for (String el : fio) {
      // Проверка длины фамилии имени или отчества на длину более 4х символов
      if (el.length() < 4) {
        throw new FioFormatException("Некорректные данные для имени, фамилии или отчества:", el);
        // Проверка если пользователь ввел больше данных чем нужен
      } else if (fio.length > 3) {
        throw new FioFormatException("Некорректные данные для ФИО:", x);
      }
    }

    // Ввод даты рождения
    System.out.println("Введите свою дату рождения в формате dd,mm,yyyy");
    String dateOfBirth = scanner.next();
    String[] dateOfBirthArray = dateOfBirth.split(",");
    // Проверка на корректный ввод даты, месяца, года
    if (dateOfBirthArray[0].length() != 2) {
      throw new UnsupportedDataFormat("Не корректная дата рождения - ", dateOfBirthArray[0]);
    } else if (dateOfBirthArray[1].length() != 2) {
      throw new UnsupportedDataFormat("Не корректный месяц рождения - ", dateOfBirthArray[1]);
    } else if (dateOfBirthArray[2].length() != 4) {
      throw new UnsupportedDataFormat("Не корректный год рождения - ", dateOfBirthArray[2]);
    }
    // Ввод номера телефона
    System.out.println("Введите номер телефона без +");
    String phoneNumber = scanner.next();
    String[] phoneNumberArray = phoneNumber.split("");
    // Проверка на начальный символ номера телефона
    if (Integer.parseInt(phoneNumberArray[0]) != 7) {
      throw new PhoneNumberException("Номер должен начинаться с символа '7', а у вас - ",
          Integer.parseInt(phoneNumberArray[0]));
      // Проверка на длину телефонного номера
    } else if (phoneNumberArray.length != 11) {
      throw new PhoneNumberException("Неверная длина телефонного номера, должно быть 11 цифр, а у вас - ",
          phoneNumberArray.length);
    }

    // Ввод пола человека
    System.out.println("Выберите пол мужской / женский");
    String gender = scanner.next();
    String male = "мужской";
    String female = "женский";
    if (gender.equals(male)) {
    } else if (gender.equals(female)) {
    } else {
      throw new GenderSelectionException("Не корректно введено поле пола человека - ", gender);
    }

    // Запись данных в новый файл с именем "fio[0].txt"
    try (FileWriter fw = new FileWriter(fio[0] + ".txt")) {
      fw.write("Фамилия: " + fio[0] + "\n");
      fw.write("Имя: " + fio[1] + "\n");
      fw.write("Отчество: " + fio[2] + "\n");
      fw.write("Дата рождения: " + dateOfBirthArray[0] + "." + dateOfBirthArray[1] + "." + dateOfBirthArray[2] + "\n");
      fw.write("Номер телефона: +" + phoneNumber + "\n");
      fw.write("Пол: " + gender + "\n");
      System.out.println("Файл создан успешно!");
    }
  }

  public static void main(String[] args) {
    try {
      inputFio();
    } catch (FioFormatException e) {
      System.out.println(e.getMessage() + e.getFio());
    } catch (IOException e) {
      System.out.println("Ошибка чтения или записи файла");
      e.getStackTrace();
    } catch (UnsupportedDataFormat e) {
      System.out.println(e.getMessage() + e.getDate());
    } catch (PhoneNumberException e) {
      System.out.println(e.getMessage() + e.getNumber());
    } catch (GenderSelectionException e) {
      System.out.println(e.getMessage() + e.getGender());
    }
  }
}
