.class Lm/e/huyen2/luu$1;
.super Ljava/lang/Object;
.source "luu.java"

# interfaces
.implements Landroid/view/View$OnClickListener;


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lm/e/huyen2/luu;->onCreate(Landroid/os/Bundle;)V
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = null
.end annotation


# instance fields
.field final synthetic this$0:Lm/e/huyen2/luu;


# direct methods
.method constructor <init>(Lm/e/huyen2/luu;)V
    .locals 0

    .prologue
    .line 1
    iput-object p1, p0, Lm/e/huyen2/luu$1;->this$0:Lm/e/huyen2/luu;

    .line 38
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public onClick(Landroid/view/View;)V
    .locals 10
    .param p1, "v"    # Landroid/view/View;

    .prologue
    const/4 v9, 0x0

    .line 42
    iget-object v6, p0, Lm/e/huyen2/luu$1;->this$0:Lm/e/huyen2/luu;

    iget-object v6, v6, Lm/e/huyen2/luu;->e:Landroid/widget/EditText;

    invoke-virtual {v6}, Landroid/widget/EditText;->getText()Landroid/text/Editable;

    move-result-object v6

    invoke-interface {v6}, Landroid/text/Editable;->toString()Ljava/lang/String;

    move-result-object v4

    .line 44
    .local v4, "na":Ljava/lang/String;
    if-eqz v4, :cond_0

    invoke-virtual {v4}, Ljava/lang/String;->trim()Ljava/lang/String;

    move-result-object v6

    const-string v7, ""

    invoke-virtual {v6, v7}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v6

    if-eqz v6, :cond_1

    .line 45
    :cond_0
    iget-object v6, p0, Lm/e/huyen2/luu$1;->this$0:Lm/e/huyen2/luu;

    const-string v7, "Please enter name of house"

    invoke-static {v6, v7, v9}, Landroid/widget/Toast;->makeText(Landroid/content/Context;Ljava/lang/CharSequence;I)Landroid/widget/Toast;

    move-result-object v6

    invoke-virtual {v6}, Landroid/widget/Toast;->show()V

    .line 78
    :goto_0
    return-void

    .line 50
    :cond_1
    iget-object v6, p0, Lm/e/huyen2/luu$1;->this$0:Lm/e/huyen2/luu;

    new-instance v7, Ljava/lang/StringBuilder;

    const-string v8, "House of "

    invoke-direct {v7, v8}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    invoke-virtual {v7, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v7

    const-string v8, ", "

    invoke-virtual {v7, v8}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v7

    iget-object v8, p0, Lm/e/huyen2/luu$1;->this$0:Lm/e/huyen2/luu;

    iget-object v8, v8, Lm/e/huyen2/luu;->chi:Ljava/lang/String;

    invoke-virtual {v7, v8}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v7

    invoke-virtual {v7}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v7

    iput-object v7, v6, Lm/e/huyen2/luu;->list:Ljava/lang/String;

    .line 53
    :try_start_0
    iget-object v6, p0, Lm/e/huyen2/luu$1;->this$0:Lm/e/huyen2/luu;

    const-string v7, "danhsach.txt"

    const v8, 0x8000

    invoke-virtual {v6, v7, v8}, Lm/e/huyen2/luu;->openFileOutput(Ljava/lang/String;I)Ljava/io/FileOutputStream;

    move-result-object v1

    .line 55
    .local v1, "fos":Ljava/io/FileOutputStream;
    new-instance v5, Ljava/io/OutputStreamWriter;

    invoke-direct {v5, v1}, Ljava/io/OutputStreamWriter;-><init>(Ljava/io/OutputStream;)V

    .line 57
    .local v5, "osw":Ljava/io/OutputStreamWriter;
    new-instance v6, Ljava/lang/StringBuilder;

    iget-object v7, p0, Lm/e/huyen2/luu$1;->this$0:Lm/e/huyen2/luu;

    iget-object v7, v7, Lm/e/huyen2/luu;->list:Ljava/lang/String;

    invoke-static {v7}, Ljava/lang/String;->valueOf(Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v7

    invoke-direct {v6, v7}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    const-string v7, "\n"

    invoke-virtual {v6, v7}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v6

    invoke-virtual {v6}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v6

    invoke-virtual {v5, v6}, Ljava/io/OutputStreamWriter;->append(Ljava/lang/CharSequence;)Ljava/io/Writer;

    .line 58
    invoke-virtual {v5}, Ljava/io/OutputStreamWriter;->flush()V

    .line 59
    invoke-virtual {v5}, Ljava/io/OutputStreamWriter;->close()V
    :try_end_0
    .catch Ljava/io/FileNotFoundException; {:try_start_0 .. :try_end_0} :catch_0
    .catch Ljava/io/IOException; {:try_start_0 .. :try_end_0} :catch_1

    .line 68
    .end local v1    # "fos":Ljava/io/FileOutputStream;
    .end local v5    # "osw":Ljava/io/OutputStreamWriter;
    :goto_1
    iget-object v6, p0, Lm/e/huyen2/luu$1;->this$0:Lm/e/huyen2/luu;

    invoke-virtual {v6}, Lm/e/huyen2/luu;->getIntent()Landroid/content/Intent;

    move-result-object v3

    .line 72
    .local v3, "in23":Landroid/content/Intent;
    iget-object v6, p0, Lm/e/huyen2/luu$1;->this$0:Lm/e/huyen2/luu;

    const/4 v7, 0x3

    invoke-virtual {v6, v7, v3}, Lm/e/huyen2/luu;->setResult(ILandroid/content/Intent;)V

    .line 73
    iget-object v6, p0, Lm/e/huyen2/luu$1;->this$0:Lm/e/huyen2/luu;

    invoke-virtual {v6}, Lm/e/huyen2/luu;->finish()V

    .line 74
    iget-object v6, p0, Lm/e/huyen2/luu$1;->this$0:Lm/e/huyen2/luu;

    const-string v7, "Data saved"

    invoke-static {v6, v7, v9}, Landroid/widget/Toast;->makeText(Landroid/content/Context;Ljava/lang/CharSequence;I)Landroid/widget/Toast;

    move-result-object v6

    invoke-virtual {v6}, Landroid/widget/Toast;->show()V

    .line 75
    iget-object v6, p0, Lm/e/huyen2/luu$1;->this$0:Lm/e/huyen2/luu;

    const-string v7, "input_method"

    invoke-virtual {v6, v7}, Lm/e/huyen2/luu;->getSystemService(Ljava/lang/String;)Ljava/lang/Object;

    move-result-object v2

    check-cast v2, Landroid/view/inputmethod/InputMethodManager;

    .line 76
    .local v2, "imm":Landroid/view/inputmethod/InputMethodManager;
    iget-object v6, p0, Lm/e/huyen2/luu$1;->this$0:Lm/e/huyen2/luu;

    iget-object v6, v6, Lm/e/huyen2/luu;->e:Landroid/widget/EditText;

    invoke-virtual {v6}, Landroid/widget/EditText;->getWindowToken()Landroid/os/IBinder;

    move-result-object v6

    invoke-virtual {v2, v6, v9}, Landroid/view/inputmethod/InputMethodManager;->hideSoftInputFromWindow(Landroid/os/IBinder;I)Z

    goto/16 :goto_0

    .line 61
    .end local v2    # "imm":Landroid/view/inputmethod/InputMethodManager;
    .end local v3    # "in23":Landroid/content/Intent;
    :catch_0
    move-exception v0

    .line 63
    .local v0, "e":Ljava/io/FileNotFoundException;
    invoke-virtual {v0}, Ljava/io/FileNotFoundException;->printStackTrace()V

    goto :goto_1

    .line 64
    .end local v0    # "e":Ljava/io/FileNotFoundException;
    :catch_1
    move-exception v0

    .line 65
    .local v0, "e":Ljava/io/IOException;
    invoke-virtual {v0}, Ljava/io/IOException;->printStackTrace()V

    goto :goto_1
.end method
