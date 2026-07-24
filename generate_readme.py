import os
import urllib.parse

def generate_readme(root_dir, repo_url, output_file):
    # Dictionary to store topic -> list of (question_name, link)
    topics = {}
    
    for dirpath, dirnames, filenames in os.walk(root_dir):
        if '.git' in dirpath.split(os.sep):
            continue
            
        topic = os.path.basename(dirpath)
        if topic == '.' or topic == '':
            continue
            
        java_files = [f for f in filenames if f.endswith('.java')]
        if java_files:
            if topic not in topics:
                topics[topic] = []
                
            for filename in java_files:
                filepath = os.path.join(dirpath, filename)
                rel_path = os.path.relpath(filepath, root_dir)
                rel_path_forward_slash = rel_path.replace('\\', '/')
                
                parts = rel_path_forward_slash.split('/')
                encoded_parts = [urllib.parse.quote(part) for part in parts]
                encoded_path = '/'.join(encoded_parts)
                
                github_link = f"{repo_url}/blob/main/{encoded_path}"
                question_name = os.path.splitext(filename)[0]
                
                topics[topic].append((question_name, github_link))
                
    with open(output_file, mode='w', encoding='utf-8') as f:
        f.write("# DSA Java Programs\n\n")
        f.write("![Java](https://img.shields.io/badge/Java-ED8B00?style=for-the-badge&logo=java&logoColor=white)\n")
        f.write("![DSA](https://img.shields.io/badge/Data_Structures-&_Algorithms-blue?style=for-the-badge)\n\n")
        f.write("> A comprehensive, well-documented collection of Data Structures and Algorithms implemented in Java. \n> Designed to be a 'Gold Standard' resource for revision and learning.\n\n")
        
        f.write("## Overview\n")
        f.write("This repository contains various DSA concepts categorized by topic. Each folder corresponds to a specific data structure or algorithmic paradigm, containing cleanly written and documented Java programs.\n\n")
        
        f.write("## Table of Contents\n\n")
        
        for topic in sorted(topics.keys()):
            f.write(f"### {topic}\n")
            for q_name, link in sorted(topics[topic]):
                f.write(f"- [{q_name}]({link})\n")
            f.write("\n")
            
        f.write("---\n")
        f.write("## How to Use\n")
        f.write("1. **Navigate** to the topic of interest using the Table of Contents above.\n")
        f.write("2. **Click** on the problem name to jump directly to the source code.\n")
        f.write("3. Inside the source code, you'll find **Problem Descriptions**, **Intuition**, and **Complexity Analysis** (Time/Space) as Javadoc comments above the methods.\n")

if __name__ == '__main__':
    generate_readme('.', 'https://github.com/KSNauman/DSA-Java-pgms', 'README.md')
    print("README.md generated successfully.")
