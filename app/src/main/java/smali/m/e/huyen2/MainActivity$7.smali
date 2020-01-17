.class Lm/e/huyen2/MainActivity$7;
.super Ljava/lang/Object;
.source "MainActivity.java"

# interfaces
.implements Landroid/view/View$OnClickListener;


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lm/e/huyen2/MainActivity;->onCreate(Landroid/os/Bundle;)V
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = null
.end annotation


# instance fields
.field final synthetic this$0:Lm/e/huyen2/MainActivity;


# direct methods
.method constructor <init>(Lm/e/huyen2/MainActivity;)V
    .locals 0

    .prologue
    .line 1
    iput-object p1, p0, Lm/e/huyen2/MainActivity$7;->this$0:Lm/e/huyen2/MainActivity;

    .line 1253
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public onClick(Landroid/view/View;)V
    .locals 5
    .param p1, "v"    # Landroid/view/View;

    .prologue
    .line 1257
    new-instance v3, Ljava/lang/StringBuilder;

    iget-object v4, p0, Lm/e/huyen2/MainActivity$7;->this$0:Lm/e/huyen2/MainActivity;

    iget-object v4, v4, Lm/e/huyen2/MainActivity;->doso:Ljava/lang/String;

    invoke-static {v4}, Ljava/lang/String;->valueOf(Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v4

    invoke-direct {v3, v4}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    const-string v4, " degrees, "

    invoke-virtual {v3, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v3

    const-string v4, "period "

    invoke-virtual {v3, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v3

    iget-object v4, p0, Lm/e/huyen2/MainActivity$7;->this$0:Lm/e/huyen2/MainActivity;

    iget-object v4, v4, Lm/e/huyen2/MainActivity;->van:Ljava/lang/String;

    invoke-virtual {v3, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v3

    invoke-virtual {v3}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v1

    .line 1259
    .local v1, "gio4":Ljava/lang/String;
    new-instance v2, Landroid/content/Intent;

    iget-object v3, p0, Lm/e/huyen2/MainActivity$7;->this$0:Lm/e/huyen2/MainActivity;

    const-class v4, Lm/e/huyen2/luu;

    invoke-direct {v2, v3, v4}, Landroid/content/Intent;-><init>(Landroid/content/Context;Ljava/lang/Class;)V

    .line 1260
    .local v2, "intent":Landroid/content/Intent;
    new-instance v0, Landroid/os/Bundle;

    invoke-direct {v0}, Landroid/os/Bundle;-><init>()V

    .line 1261
    .local v0, "bun2":Landroid/os/Bundle;
    const-string v3, "giocz"

    invoke-virtual {v0, v3, v1}, Landroid/os/Bundle;->putString(Ljava/lang/String;Ljava/lang/String;)V

    .line 1262
    invoke-virtual {v2, v0}, Landroid/content/Intent;->putExtras(Landroid/os/Bundle;)Landroid/content/Intent;

    .line 1263
    iget-object v3, p0, Lm/e/huyen2/MainActivity$7;->this$0:Lm/e/huyen2/MainActivity;

    invoke-virtual {v3, v2}, Lm/e/huyen2/MainActivity;->startActivity(Landroid/content/Intent;)V

    .line 1271
    return-void
.end method
