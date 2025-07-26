# Git + CMD Basics & Workflow

## 🖥️ Command Line Basics (Minimal Core Commands)

### 🔧 Creating and Navigating Folders

```bash
mkdir [folder]     # Make a new directory
cd [folder]        # Change directory to [folder]
```

### 📄 Creating Files

```bash
touch [file1] [file2]  # Create new files
```

---

## 🌀 Initialize Git Repository

```bash
git init         # Initialize a git-compatible repository
```

---

## ➕ Adding Files

```bash
git add [files]  # Add specific files to staging
git add .        # Add all current files in repository to staging
```

---

## ✅ Committing Changes

```bash
git commit -m "label/action"   # Save snapshot with a message
```

---

## 🗑️ Remove Files

```bash
rm [file]        # Delete a file
```

---

## 📋 List Directory Contents

```bash
ls               # List files in the current directory
```

---

## 🧾 Commit History

```bash
git log          # Show commit history
```

---

## 🔁 Switch Versions

```bash
git checkout [commit ID]  # Move to a specific commit
```

---

## 🗃️ Git Workflow Diagram

```
           +-------------+
           |   Remote    |     (e.g., GitHub)
           |  (origin)   |
           +-------------+
                ▲   ▲
                |   |
        git push|   |git pull
                ▼   ▼
         +-----------------+
         |   Repository    |   (HEAD, version control)
         |   (Saved Area)  |
         +-----------------+
                   ▲
                   | git checkout
                   ▼
         +-------------------+
         |  Staging Area     |   (index, review)
         |  = temp.git       |
         +-------------------+
                   ▲
                   | git add
                   ▼
         +-------------------+
         | Working Directory |   (local files)
         +-------------------+
```

---

## 🔄 Common Flow

1. `touch file.txt` → create a file
2. `git add file.txt` → stage the file
3. `git commit -m "Add file"` → commit the file
4. `git log` → view history
5. `git push` / `git pull` → interact with remote repo

---
