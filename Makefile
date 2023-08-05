# Java compiler
JAVAC = javac

# Source directory
SRCDIR = E:/Calculator

# List of Java source files
SOURCES = $(wildcard $(SRCDIR)/*.java)

# Default target
all: $(SOURCES)
	$(JAVAC) $(SOURCES)

# Clean target to remove compiled class files
clean:
	rm -f $(SRCDIR)/*.class