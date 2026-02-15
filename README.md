# 🚀 monoJ (V1)

monoJ is a simple beginner-friendly programming language built using Java.

monoJ is a transpiled language that converts monoJ code into Java code, compiles it using `javac`, and runs it automatically.

This is Version 1 (V1) of monoJ.

---

## 🎯 Goals of monoJ

- Easy to write
- Minimal syntax
- Beginner friendly
- Feels like "Java Jr"
- Built fully using Java
- Educational project to understand compiler design

---

## 🏗 How monoJ Works

Pipeline:

```
monoJ Source
   ↓
Lexer
   ↓
Parser
   ↓
Java Code Generator
   ↓
Generated .java file
   ↓
javac
   ↓
JVM Execution
```

monoJ is a **transpiler**, not a direct compiler.

---

## ✅ Supported Features (V1)

### 1️⃣ Variable Declaration

```
number a = 10
string name = "hello"
```

- `number` → `Integer` in Java
- `string` → `String` in Java

---

### 2️⃣ Display / Print

```
display a
display 10
display "hello"
```

Translates internally to:

```java
System.out.println(...)
```

---

## 🧪 Example

### monoJ Input

```
number a = 10
string b = "2020"
display a
display 10
display "sdsdasa"
```

---

### Generated Java Code

```java
public class MonoRun {
    public static void main(String[] args) {
        Integer a = 10;
        String b = "2020";
        System.out.println(a);
        System.out.println("10");
        System.out.println("sdsdasa");
    }
}
```

---

### Output

```
10
10
sdsdasa
```

---

## 🛠 Requirements

To run monoJ V1:

- Java JDK (not just JVM)
- `javac` must be available in system PATH

Check using:

```
javac -version
```

If this works, monoJ will work.

---

## ▶ How to Run monoJ

If packaged as a JAR:

```
java -jar monoj.jar
```

monoJ will:
1. Take monoJ input
2. Generate Java file
3. Compile it using `javac`
4. Execute it
5. Print program output

---

## 📂 Project Structure

```
monoJ/
 ├── lexer/
 ├── parser/
 ├── codegen/
 ├── semantic/
 └── Main.java
```

---

## ⚠ Current Limitations (V1)

- No arithmetic expressions (`10 + 5`)
- No variable reassignment
- No loops
- No conditionals
- No functions
- No type inference
- Uses delimiter-based intermediate representation
- Requires JDK installed

This is an educational prototype.

---

## 🧠 Future Plans (V2)

- Arithmetic support
- Variable reassignment
- File-based `.mj` execution
- REPL mode
- Replace delimiter IR with structured AST
- Use `JavaCompiler` API instead of external `javac`
- Improved error handling

---

## 👨‍💻 Author

monoJ was created as a learning project to deeply understand:

- How compilers work
- How lexers tokenize code
- How parsers validate grammar
- How transpilers generate code
- How JVM executes bytecode

---

## 📜 License

Open-source. Free to use and modify.

---

# 🚀 monoJ V1 Status

- ✔ Lexer implemented
- ✔ Parser implemented
- ✔ Java code generation
- ✔ Automatic compilation
- ✔ Automatic execution
- ✔ Runnable via JAR

monoJ V1 is fully functional.
