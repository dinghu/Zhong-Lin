.class Lcom/alien/demo/feature/tagaccess/BasicAccessFragment$10;
.super Ljava/lang/Object;
.source "BasicAccessFragment.java"

# interfaces
.implements Landroid/view/View$OnClickListener;


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lcom/alien/demo/feature/tagaccess/BasicAccessFragment;->setupEvents()V
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = null
.end annotation


# instance fields
.field final synthetic this$0:Lcom/alien/demo/feature/tagaccess/BasicAccessFragment;


# direct methods
.method constructor <init>(Lcom/alien/demo/feature/tagaccess/BasicAccessFragment;)V
    .locals 0

    .prologue
    .line 268
    iput-object p1, p0, Lcom/alien/demo/feature/tagaccess/BasicAccessFragment$10;->this$0:Lcom/alien/demo/feature/tagaccess/BasicAccessFragment;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public onClick(Landroid/view/View;)V
    .locals 3
    .param p1, "view"    # Landroid/view/View;

    .prologue
    .line 271
    iget-object v0, p0, Lcom/alien/demo/feature/tagaccess/BasicAccessFragment$10;->this$0:Lcom/alien/demo/feature/tagaccess/BasicAccessFragment;

    # getter for: Lcom/alien/demo/feature/tagaccess/BasicAccessFragment;->context:Landroid/app/Activity;
    invoke-static {v0}, Lcom/alien/demo/feature/tagaccess/BasicAccessFragment;->access$300(Lcom/alien/demo/feature/tagaccess/BasicAccessFragment;)Landroid/app/Activity;

    move-result-object v0

    const-string v1, "Read field..."

    new-instance v2, Lcom/alien/demo/feature/tagaccess/BasicAccessFragment$10$1;

    invoke-direct {v2, p0}, Lcom/alien/demo/feature/tagaccess/BasicAccessFragment$10$1;-><init>(Lcom/alien/demo/feature/tagaccess/BasicAccessFragment$10;)V

    invoke-static {v0, v1, v2}, Lcom/alien/demo/uibase/TaskRunner;->runTask(Landroid/content/Context;Ljava/lang/String;Ljava/lang/Runnable;)V

    .line 285
    return-void
.end method
