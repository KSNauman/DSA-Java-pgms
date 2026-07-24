import os
import urllib.parse

def generate_sub_readmes(root_dir, repo_url):
    for dirpath, dirnames, filenames in os.walk(root_dir):
        if '.git' in dirpath.split(os.sep):
            continue
            
        topic = os.path.basename(dirpath)
        if topic == '.' or topic == '':
            continue
            
        java_files = [f for f in filenames if f.endswith('.java')]
        if java_files:
            output_file = os.path.join(dirpath, 'README.md')
            with open(output_file, mode='w', encoding='utf-8') as f:
                f.write(f"# Topic: {topic}\n\n")
                f.write(f"This directory contains Java implementations related to **{topic}**.\n\n")
                f.write("## Problems\n\n")
                
                for filename in sorted(java_files):
                    filepath = os.path.join(dirpath, filename)
                    rel_path = os.path.relpath(filepath, root_dir)
                    rel_path_forward_slash = rel_path.replace('\\', '/')
                    
                    parts = rel_path_forward_slash.split('/')
                    encoded_parts = [urllib.parse.quote(part) for part in parts]
                    encoded_path = '/'.join(encoded_parts)
                    
                    github_link = f"{repo_url}/blob/main/{encoded_path}"
                    question_name = os.path.splitext(filename)[0]
                    
                    f.write(f"- [{question_name}]({github_link})\n")
            print(f"Generated README for {topic}")

if __name__ == '__main__':
    generate_sub_readmes('.', 'https://github.com/KSNauman/DSA-Java-pgms')
    print("All sub-READMEs generated successfully.")
