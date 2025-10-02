import os
import subprocess
from datetime import datetime, timedelta

# Settings
start_date = datetime(2025, 11, 12)
code_dir = '.'  # Current directory
js_files = [f for f in os.listdir(code_dir) if f.endswith('.html')]
js_files.sort()

# Loop through files and commit with a different date
for i, file in enumerate(js_files):
    commit_date = (start_date + timedelta(days=i)).strftime("%Y-%m-%dT12:00:00")
    
    # Stage the file
    subprocess.run(["git", "add", file])
    
    # Commit with custom date
    env = os.environ.copy()
    env["GIT_AUTHOR_DATE"] = commit_date
    env["GIT_COMMITTER_DATE"] = commit_date
    subprocess.run(["git", "commit", "-m", f"Add {file}"], env=env)

print("✅ All files committed.")
